package com.nssol.model;

import java.io.Serializable;

public class TBasicInfo implements Serializable {

	private static final long serialVersionUID = 7579890050219013424L;
  
	 private String type;
	 private String value;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
