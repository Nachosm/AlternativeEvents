package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.Event;

@Repository
public class EventDAOImpl implements EventDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EventDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Event> findAll() {
		Query theQuery =
				entityManager.createQuery("from Event");
		List<Event> events = theQuery.getResultList();
		return events;
	}

	@Override
	public Event findById(BigInteger theId) {
		Event theEvent = entityManager.find(Event.class, theId);
		return theEvent;
	}

	@Override
	public List<Event> findAllByUserId(BigInteger theUserId) {
		Query theQuery =
				entityManager.createQuery("from Event where userId=:theUserId");
		theQuery.setParameter("theUserId", theUserId);
		List<Event> events = theQuery.getResultList();
		return events;
	}

	@Override
	public void save(Event theEvent) {
		Event dbEvent = entityManager.merge(theEvent);
		theEvent.setId(dbEvent.getId());
	}

	@Override
	public void delete(BigInteger theId) {
		Query theQuery =
				entityManager.createQuery("delete from Event where id=:eventId");
		theQuery.setParameter("eventId", theId);
		theQuery.executeUpdate();
	}

}
