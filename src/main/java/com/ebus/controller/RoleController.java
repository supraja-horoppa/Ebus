package com.ebus.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

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

import com.ebus.entity.CustomResponse;
import com.ebus.entity.DailyAuditReport;
import com.ebus.entity.LoginForm;
import com.ebus.entity.Operations;
import com.ebus.entity.Role;
import com.ebus.entity.RoleOperation;
import com.ebus.entity.RoleOperation.RoleOperationId;
import com.ebus.service.LoginService;
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
	LoginService loginService;
	
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
	public @ResponseBody CustomResponse listRoles(HttpServletRequest request) {
		int page = 0;
    	int rows = 0;
    	String sidx = null;
    	String sord = null;
    	Enumeration<String> e = request.getParameterNames();
    	while(e.hasMoreElements()) {
    		String param = (String) e.nextElement();
    		if(param.equals("page")) {
    			page = Integer.parseInt(request.getParameter(param));
    		} else if(param.equals("rows")) {
    			rows = Integer.parseInt(request.getParameter(param));
    		} else if(param.equals("sidx")) {
    			sidx = request.getParameter(param);
    		} else if(param.equals("sord")) {
    			sord = request.getParameter(param);
    		}
    	}
    	// Retrieve all roles from the service
    	CustomResponse response = roleService.getRoles(page, rows, sidx, sord);
    	return response;
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
        return output;
	}
	
	@RequestMapping(value="/roleOperationsList", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	
	public void createRoleOperations(@RequestParam(value="roleId")  String roleId,@RequestParam(value="avaOpList") String avaOpList) {
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
    	Role roleObj = roleService.updateRole(id, role);
       }
    
   public void deleteRole(String id) {
    	boolean roleStatus = roleService.deleteRole(id);
       }
    
    @RequestMapping(value="/optsList", method = GET)
	public @ResponseBody CustomResponse listOpts(HttpServletRequest request) {
    	int page = 0;
    	int rows = 0;
    	String sidx = null;
    	String sord = null;
    	Enumeration<String> e = request.getParameterNames();
    	while(e.hasMoreElements()) {
    		String param = (String) e.nextElement();
    		if(param.equals("page")) {
    			page = Integer.parseInt(request.getParameter(param));
    		} else if(param.equals("rows")) {
    			rows = Integer.parseInt(request.getParameter(param));
    		} else if(param.equals("sidx")) {
    			sidx = request.getParameter(param);
    		} else if(param.equals("sord")) {
    			sord = request.getParameter(param);
    		}
    	}
    	// Retrieve all roles from the service
    	CustomResponse response = operationsService.getOperations(page, rows, sidx, sord);
    	return response;
	}

}
