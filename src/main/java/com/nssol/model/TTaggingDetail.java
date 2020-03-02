package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.nssol.common.model.PageUtils;

public class TTaggingDetail extends PageUtils implements Serializable  {

	private static final long serialVersionUID = 7579890050219013454L;
	
	private String creater;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getBaggingAddress() {
		return baggingAddress;
	}

	public void setBaggingAddress(String baggingAddress) {
		this.baggingAddress = baggingAddress;
	}

	public String getTaggingAddress() {
		return taggingAddress;
	}

	public void setTaggingAddress(String taggingAddress) {
		this.taggingAddress = taggingAddress;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
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
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	private Timestamp createTime;
	private String orderNo;
	private String detailNo;
	private String skuCode;
	private String baggingAddress;
	private String userID;
	
	private String taggingAddress;
	
	private String rfid;
	
	private int isDel;
	
	
	private String modifyer;
	
	private Timestamp modifyTime;
	

}
