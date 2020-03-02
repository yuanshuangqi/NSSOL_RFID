package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TMetalcheckDetail implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;

	private String rfid;
	private String creater;
	private Timestamp createTime;
	private String orderNo;
	private String detailNo;
	private String skuCode;
	private String baggingAddress;
	private Double sensitivity;
	private String scanTime;
	
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
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
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

    public Double getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(Double sensitivity) {
        this.sensitivity = sensitivity;
    }

	public String getScanTime() {
		return scanTime;
	}

	public void setScanTime(String scanTime) {
		this.scanTime = scanTime;
	}

}
