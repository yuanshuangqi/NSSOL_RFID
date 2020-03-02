package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class T_CBM_INFO implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

	private String transactionID;
	
	private String interfaceCode;

	private String  orderNo;

	private String setCode;

	private String typeCode;

	private String packType;

	private float cartonLength;
	
	private float cartonWidth;

	private float cartonHeight;

	private float volume;

	private float netWeight;
	
	private float grossWeight;

	private float actualWeight;
	
	private String createDate;

	private String creater;

	private String createTime;

	private String modifyer;

	private Timestamp modifyTime;

	private Timestamp importTime;

	public float getCartonWidth() {
		return cartonWidth;
	}

	public void setCartonWidth(float cartonWidth) {
		this.cartonWidth = cartonWidth;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getInterfaceCode() {
		return interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public float getCartonLength() {
		return cartonLength;
	}

	public void setCartonLength(float cartonLength) {
		this.cartonLength = cartonLength;
	}

	public float getCartonHeight() {
		return cartonHeight;
	}

	public void setCartonHeight(float cartonHeight) {
		this.cartonHeight = cartonHeight;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(float netWeight) {
		this.netWeight = netWeight;
	}

	public float getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(float grossWeight) {
		this.grossWeight = grossWeight;
	}

	public float getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(float actualWeight) {
		this.actualWeight = actualWeight;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	T_CBM_INFO(){
		importTime = new Timestamp(System.currentTimeMillis());
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Timestamp getImportTime() {
		return importTime;
	}

	public void setImportTime(Timestamp importTime) {
		this.importTime = importTime;
	}

}
