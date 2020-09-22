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

import com.socialmedia.alternativeevents.entities.Marking;
import com.socialmedia.alternativeevents.entities.User;
import com.socialmedia.alternativeevents.entities.UserPicture;
import com.socialmedia.alternativeevents.service.MarkingService;
import com.socialmedia.alternativeevents.service.UserPictureService;
import com.socialmedia.alternativeevents.service.UserService;

@RestController
@RequestMapping("alternativeevents/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPictureService userPictureService;
	
	@Autowired
	private MarkingService markingService;
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return userService.findAllUser();
	}
	
	@GetMapping("/usersjsp")
	public String findAllUsersJSP(){
		 List<User> users = userService.findAllUser();
		 return "users";
	}
	
	@GetMapping(path = "/users/{userId}")
	public User getUser(@PathVariable BigInteger userId){
		User theUser = userService.findById(userId);
		
		if (theUser == null)
			throw new RuntimeException("Employee did not found - " + userId);
		
		return theUser;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		theUser.setId(BigInteger.valueOf(0));
		userService.save(theUser);
		return theUser;
	}
	
	@PutMapping("/users/{userId}")
	public User updateUser(@RequestBody User theUser, @PathVariable BigInteger userId) {
		theUser.setId((BigInteger)userId);
		userService.save(theUser);
		return theUser;
	}
	
	
	@GetMapping("/users/userpictures")
	public List<UserPicture> getUserPictures(){
		return userPictureService.findAll();
	} 
	
	@GetMapping("/users/userpictures/{userPictureId}")
	public UserPicture getUserPictureById(@PathVariable BigInteger userPictureId){
		UserPicture theUserPicture = userPictureService.findById(userPictureId);
		
		if(theUserPicture == null)
			throw new RuntimeException("UserPicture did not found - " + userPictureId);
		
		return theUserPicture;
		
	}
	
	@PostMapping("/users/userpictures")
	public UserPicture addUserPicture(@RequestBody UserPicture theUserPicture){		
		theUserPicture.setId(BigInteger.valueOf(0));
		userPictureService.save(theUserPicture);
		return theUserPicture;
	}
	
	@PutMapping("/users/userpictures/{userPictureId}")
	public UserPicture updateUserPicture(@RequestBody UserPicture theUserPicture, @PathVariable BigInteger userPictureId) {
		theUserPicture.setId((BigInteger)userPictureId);
		userPictureService.save(theUserPicture);
		return theUserPicture;
	}
	
	@DeleteMapping("/users/userpictures/{userPictureId}")
	public UserPicture DeleteUserPicture(@PathVariable BigInteger userPictureId) {
		UserPicture theUserPicture = userPictureService.findById(userPictureId);
		userPictureService.delete(userPictureId);
		return theUserPicture;
	}
	
	//////////////////////////
	// Markings
	////////////////////////////
	
	@GetMapping("/users/markings")
	public List<Marking> findAllMarkings(){
		return markingService.findAll();
	}
	
	@GetMapping("/users/markings/{userId}")
	public List<Marking> findAllMarkingsByUserId(@PathVariable BigInteger userId){
		return markingService.findAllByUserId(userId);
	}
	
	@PostMapping("/users/markings")
	public Marking addMarking(@RequestBody Marking theMarking){
		theMarking.setId(BigInteger.valueOf(0));
		markingService.save(theMarking);
		return theMarking;
	}
	
	@PutMapping("/users/markings/{markingId}")
	public Marking updateMarking(@RequestBody Marking theMarking, @PathVariable BigInteger markingId) {
		theMarking.setId((BigInteger)markingId);
		markingService.save(theMarking);
		return theMarking;
	}
	
	@DeleteMapping("/users/markings/{markingId}")
	public Marking deleteMarking(@PathVariable BigInteger markingId) {
		Marking marking = markingService.findById(markingId);
		markingService.delete(markingId);
		return marking;
	}
	
	
	
	
	
	
	
	
	
}
