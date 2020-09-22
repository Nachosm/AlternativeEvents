package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.socialmedia.alternativeevents.entities.Marking;

@Repository
public class MarkingDAOImpl implements MarkingDAO {

	private EntityManager entityManager;
	
	@Autowired
	public MarkingDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Marking> findAll() {
		Query theQuery =
				entityManager.createQuery("from Marking");
		List<Marking> markings = theQuery.getResultList();
		return markings;
	}

	@Override
	public Marking findById(BigInteger theId) {
		Marking theMarking = entityManager.find(Marking.class, theId);
		if (theMarking == null)
			throw new RuntimeException("Marking did not found - " + theId);
		return theMarking;
	}

	@Override
	public void save(Marking theMarking) {
		Marking dbMarking = entityManager.merge(theMarking);
		theMarking.setId(dbMarking.getId());
	}

	@Override
	public void delete(BigInteger theId) {
		Query theQuery =
				entityManager.createQuery("delete from Marking where id=:markingId");
		theQuery.setParameter("markingId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Marking> findAllByUserId(BigInteger theUserId) {
		Query theQuery = 
				entityManager.createQuery("from Marking where userId=:theUserId");
		theQuery.setParameter("theUserId", theUserId);
		List<Marking> markings = theQuery.getResultList();
		return markings;
	}

}
