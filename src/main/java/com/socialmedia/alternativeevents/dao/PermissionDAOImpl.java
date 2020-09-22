package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.Permission;

@Repository
public class PermissionDAOImpl implements PermissionDAO {

	private EntityManager entityManager;
	
	@Autowired
	public PermissionDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Permission> findAll() {
		
		Query theQuery =
				entityManager.createQuery("from Permission");
		
		List<Permission> permission = theQuery.getResultList();
		
		return permission;
	}

	@Override
	public Permission findById(BigInteger theId) {
		
		Permission thePermission = entityManager.find(Permission.class, theId);
		
		return thePermission;
	}

	@Override
	public void save(Permission thePermission) {
		// save or update the permission
		Permission dbPermission = entityManager.merge(thePermission);
		
		// update with id from db ... so we can get generated id for save/insert
		thePermission.setId(dbPermission.getId());

	}

	@Override
	public void delete(BigInteger theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery(
				"delete From Permission where id=:permissionId");
		
		theQuery.setParameter("permissionId", theId);
		
		theQuery.executeUpdate();

	}

}
