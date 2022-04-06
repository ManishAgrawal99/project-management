/**
 * Description: Controller for Story APIs
 * */

package com.rivi.blueprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rivi.blueprint.exception.RestApiException;
import com.rivi.blueprint.model.Story;
import com.rivi.blueprint.service.StoryService;

@Controller
@RequestMapping("api/v1/story")
public class StoryController {

	@Autowired
	private StoryService storyService;
	
	/*
	 * Controller to get all stories
	 * */
	@GetMapping
	public ResponseEntity<List<Story>> getAllStories(){
		return ResponseEntity.ok(storyService.getAllStories());
	}
	
	/*
	 * Controller to add a story
	 * */
	@PostMapping
	public ResponseEntity addStory(@RequestBody Story story) throws RestApiException {
		Story savedStory = storyService.createStory(story);
		return ResponseEntity.ok(savedStory);
	}
	
	/*
	 * Controller to update a story
	 * */
	@PutMapping
	public ResponseEntity updateStory(@RequestBody Story story) throws RestApiException {
		Story updatedStory = storyService.updateStory(story);
		return ResponseEntity.ok(updatedStory);
	}
	
	/*
	 * Controller to delete a story
	 * */
	@DeleteMapping("/{id}")
	public ResponseEntity deleteStory(@PathVariable String id) {
		storyService.deleteStory(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
