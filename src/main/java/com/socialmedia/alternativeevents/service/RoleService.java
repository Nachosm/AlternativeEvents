package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Role;

public interface RoleService {
	public List<Role> findAll();
	
	public Role findById(BigInteger theId);
	
	public void save(Role theRole);
	
	public void delete(BigInteger theId);
}
