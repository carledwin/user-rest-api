package com.carledwin.ti.user.rest.api.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carledwin.ti.user.rest.api.model.User;
import com.carledwin.ti.user.rest.api.service.UserService;
import com.carledwin.ti.user.rest.api.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAll(){
		List<User> users = (List<User>) service.findAll();
		
		if(users.isEmpty()){
			return new ResponseEntity(HttpStatus.NO_CONTENT); //or Http.Status.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id){
		logger.info("Fetching User with id{}", id);
		User user = service.findOne(id);
		
		if(user == null){
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("User with id " + id + " not found" ), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//@RequestmM
	
}
