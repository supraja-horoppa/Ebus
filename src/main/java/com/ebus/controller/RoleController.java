package com.ebus.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebus.entity.LoginForm;
import com.ebus.entity.Operations;
import com.ebus.entity.Role;
import com.ebus.entity.RoleOperation;
import com.ebus.entity.RoleOperation.RoleOperationId;
import com.ebus.service.OperationsService;
import com.ebus.service.RoleOperationService;
import com.ebus.service.RoleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	@Autowired
	RoleOperationService roleOperationService;
	
	@Autowired
	OperationsService operationsService;
	
	@RequestMapping(value = "/roleAccess", method = RequestMethod.GET)
    public String roleAccess(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	model.addAttribute("title", "Users list");
    	return "roleAccessControl";

    }
	
	@RequestMapping(value="/rolesList", method = GET)
	public @ResponseBody String listRoles() {
    	// Retrieve all users from the service
    	List<Role> roles = roleService.getRoles();
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArray = gson.toJson(roles);
        jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":"
                + roles.size() + ",\"rows\":" + jsonArray + "}";
    	return jsonArray;
	}
	
	/**
	 * role details for drop down
	 * @return
	 */
	
	@RequestMapping(value="/roles", method = GET)
	public @ResponseBody String getRoles() {
    	// Retrieve all users from the service
    	List<Role> roles = roleService.getRoles();
    	String output = "<select>";
    	for(Role role:roles) {
    		output=output+"<option value='"+role.getRoleId()+"'>"+role.getRoleName()+"</option>";
    	}
    	output = output+"</select>";
        System.out.println("roles are "+output);
       	return output;
	}
	
	@RequestMapping(value="/roleOperationsList", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	
	public void createRoleOperations(@RequestParam(value="roleId")  String roleId,@RequestParam(value="avaOpList") String avaOpList) {
    	System.out.println("--------------------"+roleId +"------"+avaOpList);
    	List<RoleOperation> roleOpEntityList = new ArrayList<RoleOperation>();
    	if(roleId!=null && avaOpList!=null){
    		String[] avaOpIdsList = avaOpList.split(",");
    		for(int i=0; i<avaOpIdsList.length;i++){
    			RoleOperationId roleOperationId = new RoleOperationId();
    			roleOperationId.setRoleId(roleId);
    			roleOperationId.setOperationId(avaOpIdsList[i]);
    			
    			RoleOperation roleOpr = new RoleOperation();
    			roleOpr.setRoleOperationId(roleOperationId);
    			roleOpEntityList.add(roleOpr);
    			System.out.println("roleOpEntityList--------"+roleOpEntityList);
    		}
    		roleOperationService.createRoleOperation(roleOpEntityList);
    	}else{
    		System.out.println("RoleId or OperationId's Null....");
    	}
	}
	
	@RequestMapping(value = "/rolesList", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRole(Model model, Role role, HttpServletRequest request) { 
		Enumeration<String> e = request.getParameterNames();
		String method = null;
		String roleId = null;
		while(e.hasMoreElements()){
			String param = (String) e.nextElement();
			if(param.equals("oper")) {
				method = request.getParameter(param);
			} else if(param.equals("roleId")) {
				roleId = request.getParameter(param);
			}
		}
		if(method.equals("add")) {
    	Role roleObj = roleService.createRole(role);
		} else if (method.equals("edit")) {
			editRole(roleId,role);
		} else if(method.equals("del")) {
			System.out.println("roleId is "+roleId);
			deleteRole(roleId);
		}
    	
    }
    
    public void editRole(String id, Role role) {
    	System.out.println("in edit controller");
    	Role roleObj = roleService.updateRole(id, role);
    	
    }
    
   public void deleteRole(String id) {
    	System.out.println("in delete user");
    	boolean roleStatus = roleService.deleteRole(id);
    	System.out.println("role is deleted "+roleStatus);
    	
    }
    
    @RequestMapping(value="/optsList", method = GET)
	public @ResponseBody String listOpts() {
    	// Retrieve all users from the service
    	List<Operations> opts = operationsService.getOperations();
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArray = gson.toJson(opts);
        jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":"
                + opts.size() + ",\"rows\":" + jsonArray + "}";
    	return jsonArray;
	}

}
