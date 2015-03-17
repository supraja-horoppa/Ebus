package com.ebus.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.OrganizationDao;
import com.ebus.entity.Organization;

public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationDao orgDao;

	public ArrayList<String> getOrganizations() {
		ArrayList<String> orgNames = new ArrayList<String>();

		ArrayList<Organization> orgList = new ArrayList<Organization>();
		try {
			orgList = orgDao.getOrganizations();
			for (Organization org : orgList) {
				orgNames.add(org.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgNames;
	}

}
