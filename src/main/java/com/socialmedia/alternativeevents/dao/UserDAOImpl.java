package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.Event;
import com.socialmedia.alternativeevents.entities.Guest;
import com.socialmedia.alternativeevents.entities.Marking;
import com.socialmedia.alternativeevents.entities.User;
import com.socialmedia.alternativeevents.entities.UserPicture;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User findById(BigInteger theId) {

		// Get User
		User theUser =
				entityManager.find(User.class, theId);
		
		// return user
		return theUser;
	}
	
	@Override
	public void save(User theUser) {
		User dbUser = entityManager.merge(theUser);
		theUser.setId(dbUser.getId());
	}

	@Override
	public void delete(BigInteger theId) {
		Query theQuery = entityManager.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", theId);
		theQuery.executeUpdate();
	}
	
	@Override
	public List<User> findAllUser() {
		
		// Create a query
		Query theQuery =
				entityManager.createQuery("from User");
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
		
		// return the results 
		return users;
	}

	@Override
	public List<Event> findAllEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPicture> findAllUserPicture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marking> findUserAllMarking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guest> findUserAllGuestFor() {
		// TODO Auto-generated method stub
		return null;
	}



}
