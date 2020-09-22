package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private EntityManager entityManager;
	
	@Autowired
	public RoleDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Role> findAll() {
		Query theQuery =
				entityManager.createQuery("from Role");
		
		List<Role> roles = theQuery.getResultList();
		/*
		@SuppressWarnings("unchecked")
		List<Role> roles = Collections.checkedList(theQuery.getResultList(), Role.class);*/
		
		return roles;
		
	}

	@Override
	public Role findById(BigInteger theId) {
		
		Role theRole = 
				entityManager.find(Role.class, theId);
		
		return theRole;
	}
	
	@Override
	public void save(Role theRole) {
		Role dbRole = entityManager.merge(theRole);
		
		theRole.setId(dbRole.getId());

	}

	@Override
	public void delete(BigInteger theId) {
		Query theQuery = entityManager.createQuery("delete from Role where id=:roleId");
		
		theQuery.setParameter("roleId", theId);
		
		theQuery.executeUpdate();

	}

}
