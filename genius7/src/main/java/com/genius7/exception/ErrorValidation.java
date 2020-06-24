package com.genius7.exception;

public class ErrorValidation {
	
	private String field;
	private String error;
	public ErrorValidation(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	

}
