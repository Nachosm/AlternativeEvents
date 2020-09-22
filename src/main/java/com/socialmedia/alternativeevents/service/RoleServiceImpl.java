package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.alternativeevents.dao.RoleDAO;
import com.socialmedia.alternativeevents.entities.Role;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleDAO roleDAO;
	
	@Autowired
	public RoleServiceImpl(@Qualifier("roleDAOImpl") RoleDAO theRoleDAO) {
		roleDAO = theRoleDAO;
	}
	
	@Override
	@Transactional
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	@Override
	@Transactional
	public Role findById(BigInteger theId) {
		return roleDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Role theRole) {
		roleDAO.save(theRole);
	}

	@Override
	@Transactional
	public void delete(BigInteger theId) {
		roleDAO.delete(theId);
	}

}
