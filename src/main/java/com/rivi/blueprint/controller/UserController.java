/**
 * Description: Controller for User APIs
 * */

package com.rivi.blueprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivi.blueprint.model.User;
import com.rivi.blueprint.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * Controller to get all users
	 * */
	@GetMapping
	public ResponseEntity<List<User>> fetchAllUsers(){
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
		return response;
	}
	
	
	
}
