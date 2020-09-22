package com.socialmedia.alternativeevents.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="userPictures")
public class UserPicture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="pictureDirectory")
	private String pictureDirectory;
	
	@Column(name="isMain")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isMain;
	
	//@JsonBackReference
	/*@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="userId")*/
	/*
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="userId")
	private User user;
	
	*/
	/*
	@Column(name="userId")
	private BigInteger userId;
	*/
	/*
	@Column(name="userId")
	private BigInteger userId;
	*/
	
	
	
	/*
	@ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="userId")
	private User user;
	*/
	
	
	@Column(name="userId")
	private BigInteger userId;
	
	public UserPicture() {
	}
	
	public UserPicture(String pictureDirectory, boolean isMain) {
		this.pictureDirectory = pictureDirectory;
		this.isMain = isMain;
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

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
	
	

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserPicture [id=" + id + ", pictureDirectory=" + pictureDirectory + ", isMain=" + isMain + ", userId="
				+ userId + "]";
	}
	
	
}
