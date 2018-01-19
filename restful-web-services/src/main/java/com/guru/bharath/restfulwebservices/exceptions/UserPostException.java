/**
 * 
 */
package com.guru.bharath.restfulwebservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author AB40286
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserPostException extends RuntimeException {
	
	public UserPostException(String message) {
		super(message);
	}

}
