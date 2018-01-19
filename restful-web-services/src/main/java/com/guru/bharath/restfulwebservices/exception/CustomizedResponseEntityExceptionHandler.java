/**
 * 
 */
package com.guru.bharath.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.guru.bharath.restfulwebservices.exceptions.PostNotFoundException;

/**
 * @author AB40286
 *
 */

// @ControllerAdvice is used to apply for all the controller
@ControllerAdvice
// RestContoller is added because it send the response back
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				req.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<?> handleUserNotFoundException(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				req.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(PostNotFoundException.class)
	public final ResponseEntity<?> handlePostNotFoundException(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				req.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

	}

}
