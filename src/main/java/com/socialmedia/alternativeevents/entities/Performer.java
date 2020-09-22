package com.socialmedia.alternativeevents.entities;

import java.math.BigInteger;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.socialmedia.alternativeevents.types.EventProgressType;

@Entity
@Table(name="performers")
public class Performer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="genre")
	private EventProgressType genre;
	
	@Column(name="startTime")
	private ZonedDateTime startTime;
	
	@Column(name="endTime")
	private ZonedDateTime endTime;
	
	@Column(name="place")
	private String place;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="eventId")
	private Event event;
	
	public Performer() {
	}

	public Performer(String name, EventProgressType genre, ZonedDateTime startTime, ZonedDateTime endTime,
			String place) {
		super();
		this.name = name;
		this.genre = genre;
		this.startTime = startTime;
		this.endTime = endTime;
		this.place = place;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventProgressType getGenre() {
		return genre;
	}

	public void setGenre(EventProgressType genre) {
		this.genre = genre;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Performers [id=" + id + ", name=" + name + ", genre=" + genre + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", place=" + place + ", event=" + event + "]";
	}
	
	
}
