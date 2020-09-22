package com.socialmedia.alternativeevents.entities;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="eventPictures")
public class EventPictures {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="pictureDirectory")
	private String pictureDirectory;
	
	@Column(name="isMain")
	private Boolean isMain;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="eventId")
	private Event event;
	
	public EventPictures() {
	}

	public EventPictures(String pictureDirectory, Boolean isMain, Event event) {
		this.pictureDirectory = pictureDirectory;
		this.isMain = isMain;
		this.event = event;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getPictureDirectory() {
		return pictureDirectory;
	}

	public void setPictureDirectory(String pictureDirectory) {
		this.pictureDirectory = pictureDirectory;
	}

	public Boolean getIsMain() {
		return isMain;
	}

	public void setIsMain(Boolean isMain) {
		this.isMain = isMain;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "EventPictures [id=" + id + ", pictureDirectory=" + pictureDirectory + ", isMain=" + isMain + ", event="
				+ event + "]";
	}
	
	
	
}
