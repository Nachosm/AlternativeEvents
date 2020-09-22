package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Event;

public interface EventService {
	public List<Event> findAll();
	
	public Event findById(BigInteger theId);
	
	public List<Event> findAllByUserId(BigInteger theUserId);
	
	public void save(Event theEvent);
	
	public void delete(BigInteger theId);
}
