package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.alternativeevents.dao.UserPictureDAO;
import com.socialmedia.alternativeevents.entities.UserPicture;

@Service
public class UserPictureServiceImpl implements UserPictureService {

	private UserPictureDAO userPictureDAO;
	
	@Autowired
	public UserPictureServiceImpl(UserPictureDAO theUserPictureDAO) {
		userPictureDAO = theUserPictureDAO;
	}
	
	@Override
	@Transactional
	public List<UserPicture> findAll() {
		return userPictureDAO.findAll();
	}

	@Override
	@Transactional
	public UserPicture findById(BigInteger theId) {
		return userPictureDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(UserPicture theUserPicture) {
		userPictureDAO.save(theUserPicture);
	}

	@Override
	@Transactional
	public void delete(BigInteger theId) {
		userPictureDAO.delete(theId);
	}

}
