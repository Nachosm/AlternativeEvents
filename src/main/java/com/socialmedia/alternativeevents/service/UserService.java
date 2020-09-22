package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Event;
import com.socialmedia.alternativeevents.entities.Guest;
import com.socialmedia.alternativeevents.entities.Marking;
import com.socialmedia.alternativeevents.entities.Role;
import com.socialmedia.alternativeevents.entities.User;
import com.socialmedia.alternativeevents.entities.UserPicture;

public interface UserService {
	
	public User findById(BigInteger theId);
	
	public void save(User theRole);
	
	public void delete(BigInteger theId);
	
	public List<User> findAllUser();
	
	public List<Event> findAllEvent();
	
	public List<UserPicture> findAllUserPicture();
	
	public List<Marking> findUserAllMarking();
	
	public List<Guest> findUserAllGuestFor();
	
}
