/**
 * Description: Message format used by Global Exception Rest Handler
 * */

package com.rivi.blueprint.model;

public class ErrorOutputModel {
	private int status;
	private String message;
	
	public ErrorOutputModel(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ErrorOutputModel() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
