package com.ebus.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ebus.entity.LoginForm;
import com.ebus.service.LoginService;
import com.ebus.service.OrganizationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	
	@Autowired
    LoginService loginService;
	
	@Autowired
	OrganizationService orgService;
	
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model){
    	LoginForm loginForm = new LoginForm();
    	ArrayList<String> orgnames = orgService.getOrganizations();
    	System.out.println("orgnames is "+ orgnames);
    	model.put("loginForm", loginForm);
        model.put("organizationList", orgnames);
        return "login";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {

    	LoginForm login = loginService.getLoginByUsername(loginForm.getUsername());
    	    	
		if(login == null) {
			return "loginfail";
		}
		String username = login.getUsername();
		String password = login.getPassword();
		if (result.hasErrors()) {
			return "loginfail";
		}
		if (loginForm.getUsername().equals(username)
				&& loginForm.getPassword().equals(password)) {
			return "loginsuccess";
		}
		return "loginfail";

    }

    @RequestMapping(value = "/userAccess", method = RequestMethod.GET)
    public String userAccess(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	model.addAttribute("title", "Users list");
    	return "userAccessControl";

    }
    
    @RequestMapping(value = "/roleAccess", method = RequestMethod.GET)
    public String roleAccess(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	model.addAttribute("title", "Users list");
    	return "roleAccessControl";

    }
    
    @RequestMapping(value = "/Home", method = RequestMethod.GET)
    public String home(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {

    	return "loginsuccess";

    }
    
    @RequestMapping(value="/usersList", method = GET)
	public @ResponseBody String listBooks() {
    	// Retrieve all users from the service
    	List<LoginForm> users = loginService.getUsers();
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArray = gson.toJson(users);
        jsonArray = "{\"page\":1,\"total\":\"2\",\"records\":"
                + users.size() + ",\"rows\":" + jsonArray + "}";
    	return jsonArray;
	}
    
}


