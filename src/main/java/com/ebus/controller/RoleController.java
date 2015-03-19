package com.ebus.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebus.entity.LoginForm;
import com.ebus.entity.Operations;
import com.ebus.entity.Role;
import com.ebus.service.OperationsService;
import com.ebus.service.RoleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
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
    		output=output+"<option value='"+role.getId()+"'>"+role.getRoleName()+"</option>";
    	}
    	output = output+"</select>";
        System.out.println("roles are "+output);
       	return output;
	}
	
	@RequestMapping(value = "/rolesList", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRole(Model model, Role role) {
    	System.out.println("in add controller");
    	Role roleObj = roleService.createRole(role);
    	
    }
    
    @RequestMapping(value = "/rolesList/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editRole(@PathVariable("id") String id,Model model,Role role) {
    	System.out.println("in controller");
    	Role roleObj = roleService.updateRole(id, role);
    	
    }
    
    @RequestMapping(value = "/rolesList/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteuser(@PathVariable("id") String id,Model model, Role role) {
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
