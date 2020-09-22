package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.UserPicture;

@Repository
public class UserPictureDAOImpl implements UserPictureDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserPictureDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<UserPicture> findAll() {
		
		Query theQuery =
				entityManager.createQuery("from UserPicture");
		
		List<UserPicture> userPictures = theQuery.getResultList();
		
		return userPictures;
	}

	@Override
	public UserPicture findById(BigInteger theId) {
		UserPicture userPicture = entityManager.find(UserPicture.class, theId);
		
		if (userPicture == null)
			throw new RuntimeException("UserPicture did not found - " + theId);
		
		return userPicture;
	}

	@Override
	public void save(UserPicture theUserPicture) {
		UserPicture dbUserPicture = entityManager.merge(theUserPicture);
		
		theUserPicture.setId(dbUserPicture.getId());

	}

	@Override
	public void delete(BigInteger theId) {
		
		Query theQuery = entityManager.createQuery("delete from UserPicture where id=:userPictureId");

		theQuery.setParameter("userPictureId", theId);
		
		theQuery.executeUpdate();
		
	}

}
