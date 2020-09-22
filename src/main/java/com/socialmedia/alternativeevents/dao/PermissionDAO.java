package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Permission;

public interface PermissionDAO {
	public List<Permission> findAll();
	
	public Permission findById(BigInteger theId);
	
	public void save(Permission thePermission);
	
	public void delete(BigInteger theId);
	
}
