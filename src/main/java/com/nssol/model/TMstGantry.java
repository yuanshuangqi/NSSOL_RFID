package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.nssol.common.Page;

public class TMstGantry extends Page implements Serializable {

	private static final long serialVersionUID = 7579890050219013424L;

	private String gantryNo;
	private String gantryName;
	private String gantryType;
	private String gantryStatus;
	private String gantryStatusTime;
	private String gantryBindStatus;
	private String gantryBindKey;
	private String creater;
	private String modifyer;
	public String getGantryNo() {
		return gantryNo;
	}
	public void setGantryNo(String gantryNo) {
		this.gantryNo = gantryNo;
	}
	public String getGantryName() {
		return gantryName;
	}
	public void setGantryName(String gantryName) {
		this.gantryName = gantryName;
	}
	public String getGantryType() {
		return gantryType;
	}
	public void setGantryType(String gantryType) {
		this.gantryType = gantryType;
	}
	public String getGantryStatus() {
		return gantryStatus;
	}
	public void setGantryStatus(String gantryStatus) {
		this.gantryStatus = gantryStatus;
	}
	public String getGantryStatusTime() {
		return gantryStatusTime;
	}
	public void setGantryStatusTime(String gantryStatusTime) {
		this.gantryStatusTime = gantryStatusTime;
	}
	public String getGantryBindStatus() {
		return gantryBindStatus;
	}
	public void setGantryBindStatus(String gantryBindStatus) {
		this.gantryBindStatus = gantryBindStatus;
	}
	public String getGantryBindKey() {
		return gantryBindKey;
	}
	public void setGantryBindKey(String gantryBindKey) {
		this.gantryBindKey = gantryBindKey;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getModifyer() {
		return modifyer;
	}
	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}
}
