package com.socialmedia.alternativeevents.entities;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.socialmedia.alternativeevents.types.EventProgressType;
import com.socialmedia.alternativeevents.types.EventProgressVisibility;

@Entity
@Table(name="eventProgress")
public class EventProgress {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="type")
	private EventProgressType type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="location")
	private String location;
	
	@Column(name="visibility")
	private EventProgressVisibility visibility;
	
	@Column(name="name")
	private String name;
	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="eventId")
	private Event event;
	
	public EventProgress() {
	}

	
	
	public EventProgress(EventProgressType type, String description, String location,
			EventProgressVisibility visibility, String name) {
		this.type = type;
		this.description = description;
		this.location = location;
		this.visibility = visibility;
		this.name = name;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public EventProgressType getType() {
		return type;
	}

	public void setType(EventProgressType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public EventProgressVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(EventProgressVisibility visibility) {
		this.visibility = visibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}



	@Override
	public String toString() {
		return "EventProgress [id=" + id + ", type=" + type + ", description=" + description + ", location=" + location
				+ ", visibility=" + visibility + ", name=" + name + "]";
	}
	
	
}
