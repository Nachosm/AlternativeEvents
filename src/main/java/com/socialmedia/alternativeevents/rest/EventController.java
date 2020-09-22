package com.socialmedia.alternativeevents.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.alternativeevents.entities.Event;
import com.socialmedia.alternativeevents.service.EventService;

@RestController
@RequestMapping("alternativeevents/api")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/events")
	public List<Event> findAllEvents(){
		List<Event> events = eventService.findAll();
		return events;
	}
	
	@GetMapping("/events/{eventId}")
	public Event getEvent (@PathVariable BigInteger eventId) {
		Event theEvent = eventService.findById(eventId);
		if (theEvent == null)
			throw new RuntimeException("Event did not found - " + eventId);
		return theEvent;
	}
	
	@GetMapping("/events/user/{userId}")
	public List<Event> findAllEventsByUserId(@PathVariable BigInteger userId){
		return eventService.findAllByUserId(userId);
	}
	
	@PostMapping("/events")
	public Event newEvent(@RequestBody Event theEvent) {
		theEvent.setId(BigInteger.valueOf(0));
		eventService.save(theEvent);
		return theEvent;
	}
	
	@PutMapping("/events/{eventId}")
	public Event updateEvent(@RequestBody Event theEvent, @PathVariable BigInteger eventId) {
		theEvent.setId((BigInteger)eventId);
		eventService.save(theEvent);
		return theEvent;
	}
	
	@DeleteMapping("/events/{eventId}")
	public Event deleteEvent(@PathVariable BigInteger eventId) {
		Event theEvent = eventService.findById(eventId);
		eventService.delete(eventId);
		return theEvent;
	}
	
}
