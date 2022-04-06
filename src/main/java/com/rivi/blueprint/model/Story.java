/**
 * Description: Model for User Story
 * */

package com.rivi.blueprint.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rivi.blueprint.enums.State;

@Document
public class Story {
	
	@Id
	private String id;
	private String title;
	private String description;
	private String completionDate;
	private String assignedTo;
	private State state;
	@DBRef
	private List<Task> tasks;
	
	public Story() {
		super();
	}

	public Story(String title, String description, String completionDate, String assignedTo, State state) {
		super();
		this.title = title;
		this.description = description;
		this.completionDate = completionDate;
		this.assignedTo = assignedTo;
		this.state = state;
	}

	public Story(String id, String title, String description, String completionDate, String assignedTo, State state,
			List<Task> tasks) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.completionDate = completionDate;
		this.assignedTo = assignedTo;
		this.state = state;
		this.tasks = tasks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
	
}