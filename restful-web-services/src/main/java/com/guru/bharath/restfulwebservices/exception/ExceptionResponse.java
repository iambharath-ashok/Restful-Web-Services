/**
 * 
 */
package com.guru.bharath.restfulwebservices.exception;

import java.util.Date;

/**
 * @author AB40286
 *
 */
public class ExceptionResponse {

	private Date date;
	private String message;
	private String description;

	public Date getDate() {
		return date;
	}

	public ExceptionResponse(Date date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		description = description;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		description = description;
	}

}
