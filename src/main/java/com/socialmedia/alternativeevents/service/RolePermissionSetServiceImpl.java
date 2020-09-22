package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.alternativeevents.dao.RolePermissionSetDAO;
import com.socialmedia.alternativeevents.entities.Permission;
import com.socialmedia.alternativeevents.entities.Role;
import com.socialmedia.alternativeevents.entities.RolePermissionSet;

@Service
public class RolePermissionSetServiceImpl implements RolePermissionSetService {

	private RolePermissionSetDAO rolePermissionSetDAO;
	
	@Autowired
	public RolePermissionSetServiceImpl(RolePermissionSetDAO theRolePermissionSetDAO) {
		rolePermissionSetDAO = theRolePermissionSetDAO;
	}
	
	@Override
	public List<RolePermissionSet> findAll() {
		return rolePermissionSetDAO.findAll();
	}

	@Override
	public RolePermissionSet findById(BigInteger rolePermissionSetId) {
		return rolePermissionSetDAO.findById(rolePermissionSetId);
	}

	@Override
	public void save(RolePermissionSet theRolePermissionSet) {
		rolePermissionSetDAO.save(theRolePermissionSet);
	}

	@Override
	public void delete(BigInteger rolePermissionSetId) {
		rolePermissionSetDAO.delete(rolePermissionSetId);
	}

	@Override
	public Role getRolePermissionSetRole(BigInteger rolePermissionSetId) {
		return rolePermissionSetDAO.getRolePermissionSetRole(rolePermissionSetId);
	}

	@Override
	public Permission getRolePermissionSetPermission(BigInteger rolePermissionSetId) {
		return rolePermissionSetDAO.getRolePermissionSetPermission(rolePermissionSetId);
	}

}
