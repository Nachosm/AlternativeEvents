package com.socialmedia.alternativeevents.entities;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="startTime")
	private ZonedDateTime startTime; 
	
	@Column(name="endTime")
	private ZonedDateTime endTime;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="userId")
	private User user;
	/*
	@OneToOne(mappedBy="event",
			fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private EventProgress eventProgress;
	
	@OneToMany(mappedBy="event",
			fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EventPictures> eventPictures;
	
	@OneToMany(mappedBy="event",
			fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Guest> guests;
	
	@OneToMany(mappedBy="event",
			fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Performer> performers;
	*/
	public Event() {
	}

	public Event(ZonedDateTime startTime, ZonedDateTime endTime, User user) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "Event [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", user=" + user + "]";
	}
	
	
	
	
}
