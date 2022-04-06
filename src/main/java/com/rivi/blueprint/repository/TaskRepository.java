/**
 * Description: Mongo repository for Tasks
 * */

package com.rivi.blueprint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rivi.blueprint.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
	
}
