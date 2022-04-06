/**
 * Description: Service class to serve User related functionalities
 * */

package com.rivi.blueprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivi.blueprint.model.User;
import com.rivi.blueprint.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Returns all users
	 * @return List
	 * */
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
}
