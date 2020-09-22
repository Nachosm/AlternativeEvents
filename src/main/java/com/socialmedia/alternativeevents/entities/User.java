package com.socialmedia.alternativeevents.entities;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.socialmedia.alternativeevents.types.Gender;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="dateOfBirth")
	private String dateOfBirth;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="isActive")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isActive;
	
	@Column(name="lastLogin")
	private ZonedDateTime lastLogin;
	
	@Column(name="accountCreated")
	private ZonedDateTime accountCreated;
	/*
	@OneToOne
	@JoinColumn(name="roleId")
	private Role roleId;
	*/
	
	@JsonManagedReference
	@Column(name="roleId")
	private BigInteger roleId;
	
	//@JsonManagedReference
	//@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	
	/*
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	private List<UserPicture> pictures;
	*/

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="userId")
	private List<UserPicture> pictures = new ArrayList<>();
	
	
	/*
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//@JoinColumn(name="userId")
	private List<Marking> markings;
	
	@OneToMany(mappedBy="user",
			fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Event> events;
	
	@OneToMany(mappedBy="user",
			fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Guest> guestFor;
	*/
	public User() {
	}

	public User(String firstName, String middleName, String lastName, String dateOfBirth,
			String username, String password, Gender gender, String email, Boolean isActive, ZonedDateTime lastLogin,
			ZonedDateTime accountCreated, BigInteger roleId) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.isActive = isActive;
		this.lastLogin = lastLogin;
		this.accountCreated = accountCreated;
		this.roleId = roleId;
	}

	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ZonedDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(ZonedDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public ZonedDateTime getAccountCreated() {
		return accountCreated;
	}

	public void setAccountCreated(ZonedDateTime accountCreated) {
		this.accountCreated = accountCreated;
	}

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public List<UserPicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<UserPicture> pictures) {
		this.pictures = pictures;
	}

	/*
	public void setPictures(List<UserPicture> pictures) {
		this.pictures = pictures;
	}
	*/
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", username=" + username + ", password=" + password + ", gender="
				+ gender + ", email=" + email + ", isActive=" + isActive + ", lastLogin=" + lastLogin
				+ ", accountCreated=" + accountCreated + ", roleId=" + roleId + ", pictures=" + pictures + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
