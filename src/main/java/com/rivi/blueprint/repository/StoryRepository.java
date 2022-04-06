/**
 * Description: Mongo repository for User Story
 * */

package com.rivi.blueprint.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rivi.blueprint.model.Story;

public interface StoryRepository extends MongoRepository<Story, String> {

}
