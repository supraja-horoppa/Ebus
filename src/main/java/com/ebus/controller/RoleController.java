package com.ebus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebus.entity.LoginForm;
import com.ebus.service.RoleService;

@Controller
public class RoleController {
	
	/*@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/roleAccess", method = RequestMethod.GET)
    public String roleAccess(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	model.addAttribute("title", "Users list");
    	return "roleAccessControl";

    }*/

}
