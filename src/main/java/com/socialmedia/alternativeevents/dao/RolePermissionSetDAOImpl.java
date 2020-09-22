package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.Permission;
import com.socialmedia.alternativeevents.entities.Role;
import com.socialmedia.alternativeevents.entities.RolePermissionSet;

@Repository
public class RolePermissionSetDAOImpl implements RolePermissionSetDAO {

	private EntityManager entityManager;
	
	@Autowired
	public RolePermissionSetDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<RolePermissionSet> findAll() {
		Query theQuery = entityManager.createQuery("from RolePermissionSet");
		
		List<RolePermissionSet> rolePermissionSets = theQuery.getResultList();
 		
		return rolePermissionSets;
	}

	@Override
	public RolePermissionSet findById(BigInteger rolePermissionSetId) {
		RolePermissionSet theRolePermissionSet = entityManager.find(RolePermissionSet.class, rolePermissionSetId);
		
		if(theRolePermissionSet == null)
			throw new RuntimeException("RolePermissionSet did not foud - " + rolePermissionSetId);
		
		return theRolePermissionSet;
	}

	@Override
	public void save(RolePermissionSet theRolePermissionSet) {
		RolePermissionSet dbRolePermissionSet = entityManager.merge(theRolePermissionSet);
		
		theRolePermissionSet.setId(dbRolePermissionSet.getId());

	}

	@Override
	public void delete(BigInteger rolePermissionSetId) {
		Query theQuery = entityManager.createQuery("delete from RolePermissionSet where id=:rolePermissionSetId");
		
		theQuery.setParameter("rolePermissionSetId", rolePermissionSetId);

		theQuery.executeUpdate();
	}

	@Override
	public Role getRolePermissionSetRole(BigInteger rolePermissionSetId) {
		RolePermissionSet rolePermissionSet = findById(rolePermissionSetId);
		Role role = rolePermissionSet.getRole();
		return role;
	}

	@Override
	public Permission getRolePermissionSetPermission(BigInteger rolePermissionSetId) {
		RolePermissionSet rolePermissionSet = findById(rolePermissionSetId);
		Permission permission = rolePermissionSet.getPermission();
		return permission;
	}

}
