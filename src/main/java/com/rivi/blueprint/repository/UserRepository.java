/**
 * Description: Mongo repository for User
 * */

package com.rivi.blueprint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rivi.blueprint.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
