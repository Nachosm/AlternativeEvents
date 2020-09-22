package com.socialmedia.alternativeevents.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.socialmedia.alternativeevents.exceptions.PageNotFoundException;

@ControllerAdvice
public class PageNotFoundAdvice {
	  @ResponseBody
	  @ExceptionHandler(PageNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(PageNotFoundException ex) {
	    return ex.getMessage();
	  }
}
