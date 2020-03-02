package com.nssol.controller.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.model.PageUtils;

public class TMstDictionaryRequest implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;


	private String dicType;

	private String cpuID;

	private String id;


	public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public String getCpuID() {
		return cpuID;
	}

	public void setCpuID(String cpuID) {
		this.cpuID = cpuID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



}
