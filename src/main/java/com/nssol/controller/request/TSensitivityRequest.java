package com.nssol.controller.request;

import com.nssol.common.model.PageUtils;

import java.io.Serializable;

public class TSensitivityRequest extends PageUtils implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;

	private String baggingAddress;
     private String createTimeStart;
     private String createTimeEnd;

	public String getCreateTimeStart() {
		return createTimeStart;
	}
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public String getBaggingAddress() {
		return baggingAddress;
	}
	public void setBaggingAddress(String baggingAddress) {
		this.baggingAddress = baggingAddress;
	}
}
