package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Permission;

public interface PermissionService {
	public List<Permission> findAll();
	
	public Permission findById(BigInteger theId);
	
	public void save(Permission thePermission);
	
	public void delete(BigInteger theId);
}
