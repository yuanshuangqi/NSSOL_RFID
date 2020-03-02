package com.nssol.controller.response;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

import com.nssol.model.TOrderDetail;

public class FilesResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private String fileName;
	private Boolean isUpdate;
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
	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
}
