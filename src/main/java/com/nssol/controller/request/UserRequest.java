package com.nssol.controller.request;

import java.io.Serializable;

public class UserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String iCCard;
	
	public String getiCCard() {
		return iCCard;
	}

	public void setiCCard(String iCCard) {
		this.iCCard = iCCard;
	}
	
}
