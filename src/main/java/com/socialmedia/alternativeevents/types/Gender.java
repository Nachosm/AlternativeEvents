package com.socialmedia.alternativeevents.types;

public enum Gender {
	MALE("MALE"),
	FEMALE("FEMALE"),
	OTHER("OTHER");
	
	private String gender;
	
	Gender(String theGender){
		gender = theGender;
	}
	
	public String getGender() {
		return gender;
	}
}
