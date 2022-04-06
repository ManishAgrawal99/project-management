/**
 * Description: Controller for Tasks APIs
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rivi.blueprint.exception.RestApiException;
import com.rivi.blueprint.model.Task;
import com.rivi.blueprint.service.TaskService;

@Controller
@RequestMapping("api/v1/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	/*
	 * Controller to add a task
	 * */
	@PostMapping
	public ResponseEntity addTask(@RequestBody Task task) throws RestApiException {
		Task savedTask = taskService.saveTask(task);
		return ResponseEntity.ok(savedTask);
	}
	
	/*
	 * Controller to delete a task
	 * */
	@DeleteMapping("/{id}")
	public ResponseEntity deleteTask(@PathVariable String id) throws RestApiException {
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * Controller to get all tasks
	 * */
	@GetMapping
	public ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.ok(taskService.getAllTasks());
	}
}
