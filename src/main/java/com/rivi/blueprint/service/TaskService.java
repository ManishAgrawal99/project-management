/**
 * Description: Service class to serve Task related functionalities
 * */

package com.rivi.blueprint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivi.blueprint.exception.RestApiException;
import com.rivi.blueprint.model.Story;
import com.rivi.blueprint.model.Task;
import com.rivi.blueprint.repository.StoryRepository;
import com.rivi.blueprint.repository.TaskRepository;
import com.rivi.blueprint.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private StoryRepository storyRepository;
	
	/**
	 * Returns all tasks
	 * @return List
	 * */
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	/**
	 * Returns the newly created task
	 * @return Task
	 * @throws RestApiException
	 * @param Task to create
	 * */
	public Task saveTask(Task task) throws RestApiException {
		
		//If user is assigned, check if the user exists
		if (task.getAssignedTo() != null && !task.getAssignedTo().isEmpty()) {
			userRepository.findById(task.getAssignedTo()).orElseThrow(
					()-> new RestApiException(String.format("Cannot Find User with email: %s", task.getAssignedTo())));
		}
		
		//Check if a story reference is provided
		if (task.getStoryId() == null || task.getStoryId().isEmpty()) {
			throw new RestApiException("Need to assign a valid story id");
		}
		else {
			//Check if story id is valid
			Story story = storyRepository.findById(task.getStoryId()).orElseThrow(
					()-> new RestApiException(String.format("Cannot Find Story with id: %s", task.getStoryId())));
			
			Task savedTask = taskRepository.save(task);
			
			//Saving task to story
			if(story.getTasks() != null) {
				story.getTasks().add(savedTask);
			}
			else {
				List<Task> tasksList = new ArrayList<>();
				tasksList.add(savedTask);
				story.setTasks(tasksList);
			}
			
			storyRepository.save(story);
			
			
			return savedTask;
		}
	}
	
	/**
	 * Deletes the task with Id received
	 * @return void
	 * @throws RestApiException
	 * @param String id
	 * */
	public void deleteTask(String id) throws RestApiException {
		//Check if task exists
		Task task = taskRepository.findById(id).orElseThrow(
				()-> new RestApiException(String.format("Cannot Find task with id: %s", id)));
		
		//Remove task from story
		Story story = storyRepository.findById(task.getStoryId()).orElse(null);
		if(story!=null && story.getTasks()!=null && !story.getTasks().isEmpty()) {
			story.getTasks().remove(task);
			storyRepository.save(story);
		}
		
		taskRepository.deleteById(id);
	}
	
}
