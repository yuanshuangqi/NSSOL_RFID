package com.nssol.controller.response;

import java.io.Serializable;

public class MessageResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1672020058832008245L;

	private String code;
	
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
