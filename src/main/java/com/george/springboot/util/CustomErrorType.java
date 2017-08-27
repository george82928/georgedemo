package com.george.springboot.util;

/**
 * A customized Class represents server error
 * 
 * @author George Zheng
 *
 */
public class CustomErrorType {

	private String message;

	public CustomErrorType(String errorMessage) {
		this.message = errorMessage;
	}

	/**
	 * Get error message
	 * 
	 * @return String of the error message
	 */
	public String getMessage() {
		return message;
	}
}
