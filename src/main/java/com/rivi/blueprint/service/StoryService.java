/**
 * Description: Service class to serve UserStory functionalities
 * */

package com.rivi.blueprint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivi.blueprint.exception.RestApiException;
import com.rivi.blueprint.model.Story;
import com.rivi.blueprint.repository.StoryRepository;
import com.rivi.blueprint.repository.TaskRepository;
import com.rivi.blueprint.repository.UserRepository;

@Service
public class StoryService {
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	/**
	 * Returns all Stories
	 * @return List
	 * */
	public List<Story> getAllStories() {
		return storyRepository.findAll();
	}
	
	
	/**
	 * Returns the updated Story
	 * @return Story
	 * @throws RestApiException
	 * @param Story to update
	 * */
	public Story updateStory(Story story) throws RestApiException {
		//If Id not received or Id not present in mongo, send error message
		if (story.getId() == null) {
			throw new RestApiException("id Cannot be null");
		}
		
		Story savedStory = storyRepository.findById(story.getId()).orElseThrow(
				()-> new RestApiException(String.format("Cannot Find Story by Id: %s", story.getId())));
		
		//Check if the user mentioned in updated story exists
		if (story.getAssignedTo() != null && !story.getAssignedTo().isEmpty()) {
			userRepository.findById(story.getAssignedTo()).orElseThrow(
					()-> new RestApiException(String.format("Cannot Find User with email: %s", story.getAssignedTo())));
		}
		
		//Update Tasks only if sent in body
		if (story.getTasks() != null) {
			savedStory.setTasks(story.getTasks());
		}
		
		savedStory.setTitle(story.getTitle());
		savedStory.setState(story.getState());
		savedStory.setDescription(story.getDescription());
		savedStory.setCompletionDate(story.getCompletionDate());
		savedStory.setAssignedTo(story.getAssignedTo());
		
		return storyRepository.save(savedStory);
	}
	
	/**
	 * Returns the newly created story
	 * @return Story
	 * @throws RestApiException
	 * @param Story to create
	 * */
	public Story createStory(Story story) throws RestApiException {
		
		//Check if user assigned exists or not
		if (story.getAssignedTo() != null && !story.getAssignedTo().isEmpty()) {
			userRepository.findById(story.getAssignedTo()).orElseThrow(
					()-> new RestApiException(String.format("Cannot Find User with email: %s", story.getAssignedTo())));
		}
		
		story.setTasks(new ArrayList<>());
		
		return storyRepository.save(story);
	}
	
	/**
	 * Deletes the story with Id received
	 * @return void
	 * @throws RestApiException
	 * @param String id
	 * */
	public void deleteStory(String id) {
		Story story = storyRepository.findById(id).orElse(null);
		
		//Remove tasks with this story reference
		if (story != null && story.getTasks()!=null && !story.getTasks().isEmpty()) {
			taskRepository.deleteAll(story.getTasks());
		}
		
		storyRepository.deleteById(id);
	}
}
