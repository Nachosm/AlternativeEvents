package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.alternativeevents.dao.EventDAO;
import com.socialmedia.alternativeevents.entities.Event;

@Service
public class EventServiceImpl implements EventService {

	private EventDAO eventDAO;
	
	@Autowired
	public EventServiceImpl(EventDAO theEventDAO) {
		eventDAO = theEventDAO;
	}
	
	@Override
	@Transactional
	public List<Event> findAll() {
		return eventDAO.findAll();
	}

	@Override
	@Transactional
	public Event findById(BigInteger theId) {
		return eventDAO.findById(theId);
	}

	@Override
	@Transactional
	public List<Event> findAllByUserId(BigInteger theUserId) {
		return eventDAO.findAllByUserId(theUserId);
	}

	@Override
	@Transactional
	public void save(Event theEvent) {
		eventDAO.save(theEvent);
	}

	@Override
	@Transactional
	public void delete(BigInteger theId) {
		eventDAO.delete(theId);
	}

}
