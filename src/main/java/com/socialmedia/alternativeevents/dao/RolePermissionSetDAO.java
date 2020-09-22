package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Permission;
import com.socialmedia.alternativeevents.entities.Role;
import com.socialmedia.alternativeevents.entities.RolePermissionSet;

public interface RolePermissionSetDAO {
	
	public List<RolePermissionSet> findAll();
	
	public RolePermissionSet findById(BigInteger rolePermissionSetId);
	
	public void save(RolePermissionSet theRolePermissionSet);
	
	public void delete(BigInteger rolePermissionSetId);
	
	public Role getRolePermissionSetRole(BigInteger rolePermissionSetId);
	
	public Permission getRolePermissionSetPermission(BigInteger rolePermissionSetId);
	
}
