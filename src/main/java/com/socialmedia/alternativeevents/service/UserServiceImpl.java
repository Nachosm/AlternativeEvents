package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.alternativeevents.dao.UserDAO;
import com.socialmedia.alternativeevents.entities.Event;
import com.socialmedia.alternativeevents.entities.Guest;
import com.socialmedia.alternativeevents.entities.Marking;
import com.socialmedia.alternativeevents.entities.Role;
import com.socialmedia.alternativeevents.entities.User;
import com.socialmedia.alternativeevents.entities.UserPicture;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User findById(BigInteger theId) {
		return userDAO.findById(theId);
	}

	@Override
	@Transactional
	public List<User> findAllUser() {
		return userDAO.findAllUser();
	}

	@Override
	@Transactional
	public List<Event> findAllEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<UserPicture> findAllUserPicture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Marking> findUserAllMarking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Guest> findUserAllGuestFor() {
		return null;
	}

	@Override
	@Transactional
	public void save(User theUser) {
		userDAO.save(theUser);
		
	}

	@Override
	@Transactional
	public void delete(BigInteger theId) {
		userDAO.delete(theId);
	}
	
}
