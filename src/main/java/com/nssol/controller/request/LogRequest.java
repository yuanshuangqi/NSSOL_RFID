package com.nssol.controller.request;

import java.io.Serializable;

public class LogRequest implements Serializable {

	private static final long serialVersionUID = 6476259118904535288L;

	private String fileName;
	private String deviceID;
	private String dateDir;
	public byte[] fileContect;

	public byte[] getFileContect() {
		return fileContect;
	}

	public void setFileContect(byte[] fileContect) {
		this.fileContect = fileContect;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getDateDir() {
		return dateDir;
	}

	public void setDateDir(String dateDir) {
		this.dateDir = dateDir;
	}
}

