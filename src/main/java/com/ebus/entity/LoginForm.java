package com.ebus.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Entity
@Table(name="product.cl_login")
public class LoginForm {

	@Id
    @Column(name="id")
    private String id;
	@Column(name="login_name")
    private String username;
	@Column(name="login_password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name="phone")
    private String phone;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="organization")
	private String organization;
	@Column(name="role")
	private String role;
	 
	 public LoginForm(){
		 
	 }
	 
	 /**
		 * Creates LoginForm object from JSON string
		 * 
		 * @param json
		 */
	public LoginForm(String json) {
			
			// Fill out default values
			loginFormDefault();

			// Override default values with JSON
			updateByJson(json);

			// Assign GUID
			id = UUID.randomUUID().toString();
		}
	
	/**
	 * Updates each field of LoginForm from JSON
	 * 
	 * @param json
	 */
	public void updateByJson(String json) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		LoginForm login = gson.fromJson(json, this.getClass());

		if (json.contains("username")) {
			this.username = login.username;
		}
		if (json.contains("password")) {
			this.password = login.password;
		}
		if (json.contains("firstName")) {
			this.firstName = login.firstName;
		}
		if (json.contains("lastName")) {
			this.lastName = login.lastName;
		}
		if (json.contains("email")) {
			this.email = login.email;
		}
		if (json.contains("phone")) {
			this.phone = login.phone;
		}
		if (json.contains("organization")) {
			this.organization = login.organization;
		}
		if (json.contains("role")) {
			this.role = login.role;
		}
		
	}

	/**
	 * Sets all default values for LoginForm object
	 */
	public void loginFormDefault() {
		this.id = "";
		this.username = "";
		this.email = "";
		this.phone = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.organization = "";
		this.role = "";
		
	}
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

   
}
