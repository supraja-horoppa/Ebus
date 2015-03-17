package com.ebus.dao;

import java.util.ArrayList;

import com.ebus.entity.Organization;

public interface OrganizationDao {
	
	public ArrayList<Organization> getOrganizations() throws Exception;

}
