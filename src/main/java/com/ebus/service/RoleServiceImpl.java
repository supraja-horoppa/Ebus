package com.ebus.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.RoleDao;
import com.ebus.entity.Role;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao roleDao;
	 
    public void setRoleDAO(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

	public Role getRoleById(String roleId) {
		return roleDao.readRoleById(roleId);
	}

	public List<Role> getRoles() {
		return roleDao.readRoles();
	}

	public Role createRole(Role role) {
		return roleDao.createRole(role);
	}

	public boolean deleteRole(String roleId) {
		return roleDao.deleteRole(roleId);
	}

	public Role updateRole(String roleId, Role role) {
		return roleDao.updateRole(roleId, role);
	}

    
}
