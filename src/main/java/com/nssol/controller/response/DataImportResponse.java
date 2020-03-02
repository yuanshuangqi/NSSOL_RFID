package com.nssol.controller.response;

import java.io.Serializable;

public class DataImportResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
