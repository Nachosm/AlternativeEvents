package com.socialmedia.alternativeevents.dao;

import java.math.BigInteger;
import java.util.List;

import com.socialmedia.alternativeevents.entities.Marking;

public interface MarkingDAO {
	
	public List<Marking> findAll();
	
	public Marking findById(BigInteger theId);
	
	public List<Marking> findAllByUserId(BigInteger theUserId);
	
	public void save(Marking theMarking);
	
	public void delete(BigInteger theId);
	
}
