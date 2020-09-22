package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.alternativeevents.dao.PermissionDAO;
import com.socialmedia.alternativeevents.entities.Permission;

@Service
public class PermissionServiceImpl implements PermissionService {

	private PermissionDAO permissionDAO;
	
	@Autowired
	public PermissionServiceImpl(@Qualifier("permissionDAOImpl") PermissionDAO thePermissionDAO) {
		permissionDAO = thePermissionDAO;
	}
	
	@Override
	@Transactional
	public List<Permission> findAll() {
		return permissionDAO.findAll();
	}

	@Override
	@Transactional
	public Permission findById(BigInteger theId) {
		return permissionDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Permission thePermission) {
		permissionDAO.save(thePermission);
	}

	@Override
	@Transactional
	public void delete(BigInteger theId) {
		permissionDAO.delete(theId);
	}

}
