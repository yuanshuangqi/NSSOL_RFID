package com.nssol.model;

import java.io.Serializable;

public class Function_Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5316399323594002318L;
	
	private String functionNo;
	
	private String functionName;
	
	private Boolean isFunctioncheck;

	public String getFunctionNo() {
		return functionNo;
	}

	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Boolean getIsFunctioncheck() {
		return isFunctioncheck;
	}

	public void setIsFunctioncheck(Boolean isFunctioncheck) {
		this.isFunctioncheck = isFunctioncheck;
	}

}
