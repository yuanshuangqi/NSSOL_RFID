package com.nssol.model;

import java.io.Serializable;

public class TMstDictionary implements Serializable {

	private static final long serialVersionUID = 7579890050219013424L;

   private String id;
   private String dicType;
   private String dicId;
   private String dicValue;
   private String cpuID;

   public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDicType() {
	return dicType;
}
public void setDicType(String dicType) {
	this.dicType = dicType;
}
public String getDicId() {
	return dicId;
}
public void setDicId(String dicId) {
	this.dicId = dicId;
}
public String getDicValue() {
	return dicValue;
}
public void setDicValue(String dicValue) {
	this.dicValue = dicValue;
}
public String getCpuID() {
		return cpuID;
	}
public void setCpuID(String cpuID) {
		this.cpuID = cpuID;
	}
}
