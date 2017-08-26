package com.george.springboot.util;

/**
 * A customized Class represents server error
 * 
 * @author George Zheng
 *
 */
public class CustomErrorType {

	private String errorMessage;

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Get error message
	 * 
	 * @return String of the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
}
