package com.ebus.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ebus.entity.CustomResponse;
import com.ebus.entity.LoginForm;
import com.ebus.service.LoginService;
import com.ebus.service.OrganizationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    	model.put("loginForm", loginForm);
        model.put("organizationList", orgnames);
        return "login";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {

    	LoginForm login = loginService.getLoginByUsername(loginForm.getUsername());
    	//loginService.dailyAuditReport();    	
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
    
    @RequestMapping(value = "/usersList", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adduser(@RequestBody String login) {
    	LoginForm loginObj = new LoginForm(login);
    	LoginForm user = loginService.createUser(loginObj);
    	
    }
    
    @RequestMapping(value = "/usersList/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void edituser(@PathVariable("id") String id,@RequestBody String login) {
    	try {
			JSONObject json = new JSONObject(login);
			if(json.has("id")&& json.getString("id")!=null){
				id = json.getString("id");
			}
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
    	LoginForm user = loginService.getLoginById(id);
    	user.updateByJson(login);
    	LoginForm userObj = loginService.updateUser(id, user);
    	
    }
    
    @RequestMapping(value = "/usersList/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteuser(@PathVariable("id") String id,Model model, LoginForm login) {
    	boolean user = loginService.deleteUser(id);
    	
    }

    @RequestMapping(value = "/userAccess", method = RequestMethod.GET)
    public String userAccess(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	model.addAttribute("title", "Users list");
    	return "userAccessControl";

    }
    
    @RequestMapping(value = "/Home", method = RequestMethod.GET)
    public String home(Model model, LoginForm loginForm, BindingResult result, RedirectAttributes redirectAttributes) {

    	return "loginsuccess";

    }
    
    @RequestMapping(value="/usersList", method = GET)
	public @ResponseBody CustomResponse listUsers(HttpServletRequest request) {
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
    	// Retrieve all users from the service
    	CustomResponse response = loginService.getUsers(page, rows, sidx, sord);
    	return response;
	}
    
}


