package com.nssol.model;

import com.nssol.common.model.PageUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TMetalcheckSensitivity extends PageUtils implements Serializable  {

	private static final long serialVersionUID = 2207413270397778090L;


	private String baggingAddress;
	private Double sensitivity;
	private Integer scanNum;
	private String scanTime;
	private String creater;
	private Timestamp createTime;


	 

	public Integer getScanNum() {
		return scanNum;
	}
	public void setScanNum(Integer scanNum) {
		this.scanNum = scanNum;
	}



	public Double getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(Double sensitivity) {
		this.sensitivity = sensitivity;
	}

	public String getBaggingAddress() {
		return baggingAddress;
	}

	public void setBaggingAddress(String baggingAddress) {
		this.baggingAddress = baggingAddress;
	}



	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getScanTime() {
		return scanTime;
	}

	public void setScanTime(String scanTime) {
		this.scanTime = scanTime;
	}
}
