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
import com.ebus.entity.Role;
import com.ebus.service.RoleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
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
	
	@RequestMapping(value = "/rolesList", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRole(Model model, Role role) {
    	System.out.println("in add controller");
    	Role roleObj = roleService.createRole(role);
    	//return "loginsuccess";
    }
    
    @RequestMapping(value = "/rolesList/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editRole(@PathVariable("id") String id,Model model,Role role) {
    	System.out.println("in controller");
    	Role roleObj = roleService.updateRole(id, role);
    	//return "loginsuccess";
    }
    
    @RequestMapping(value = "/rolesList/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteuser(@PathVariable("id") String id,Model model, Role role) {
    	System.out.println("in delete user");
    	boolean roleStatus = roleService.deleteRole(id);
    	System.out.println("role is deleted "+roleStatus);
    	//return "loginsuccess";
    }

}
