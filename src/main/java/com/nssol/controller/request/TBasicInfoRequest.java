package com.nssol.controller.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.model.PageUtils;

public class TBasicInfoRequest implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;


	private String type;


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}
