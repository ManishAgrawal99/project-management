/**
 * Description: Exception created as a wrapper for all thrown exceptions
 * */

package com.rivi.blueprint.exception;

public class RestApiException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public RestApiException(String message) {
		super(message);
	}
}
