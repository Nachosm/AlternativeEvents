package com.socialmedia.alternativeevents.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.alternativeevents.dao.MarkingDAO;
import com.socialmedia.alternativeevents.entities.Marking;

@Service
public class MarkingServiceImpl implements MarkingService {

	private MarkingDAO markingDAO;
	
	@Autowired
	public MarkingServiceImpl(MarkingDAO markingDAO) {
		this.markingDAO = markingDAO;
	}

	@Override
	@Transactional
	public List<Marking> findAll() {
		return markingDAO.findAll();
	}

	@Override
	@Transactional
	public Marking findById(BigInteger theId) {
		return markingDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Marking theMarking) {
		markingDAO.save(theMarking);
	}

	@Override
	@Transactional
	public void delete(BigInteger theId) {
		markingDAO.delete(theId);
	}

	@Override
	@Transactional
	public List<Marking> findAllByUserId(BigInteger theUserId) {
		return markingDAO.findAllByUserId(theUserId);
	}

}
