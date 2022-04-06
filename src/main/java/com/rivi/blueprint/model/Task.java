/**
 * Description: Model for Tasks
 * */

package com.rivi.blueprint.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
	
	@Id
	private String id;
	private String title;
	private String description;
	private String storyId;
	private String assignedTo;
	
	public Task() {
	}

	public Task(String id, String title, String description, String storyId, String assignedTo) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.storyId = storyId;
		this.assignedTo = assignedTo;
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

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if(! (obj instanceof Task)) {
			return false;
		}
		Task t = (Task) obj;
		return this.id.equals(t.id);
	}
	
	
	
	
	
}
