package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.UserPicture;

public interface UserPictureService {
	
	public List<UserPicture> findAll();
	
	public UserPicture findById(BigInteger theId);
	
	public void save(UserPicture theUserPicture);
	
	public void delete(BigInteger theId);
}
