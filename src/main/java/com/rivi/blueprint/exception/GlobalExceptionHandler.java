/**
 * Description: Exception Handler to convert generic Error responses to error specific responses 
 * */

package com.rivi.blueprint.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rivi.blueprint.model.ErrorOutputModel;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * Handle Rest APi Exceptions thrown by Application
	 * */
	@ExceptionHandler(value = {RestApiException.class})
	public ResponseEntity<Object> handleRestApiException(RestApiException ex, WebRequest request){
		
		ErrorOutputModel errorOutputModel = new ErrorOutputModel();
		errorOutputModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorOutputModel.setMessage(ex.getMessage());
		
		return handleExceptionInternal(ex, errorOutputModel, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
