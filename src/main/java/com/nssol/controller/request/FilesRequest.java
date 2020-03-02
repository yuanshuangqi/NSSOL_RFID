package com.nssol.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Stream;

import com.nssol.common.model.PageUtils;

public class FilesRequest implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;


	private String fileName;


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
