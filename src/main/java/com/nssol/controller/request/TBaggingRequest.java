package com.nssol.controller.request;

import java.io.Serializable;
import java.util.Date;

import com.nssol.common.model.PageUtils;

public class TBaggingRequest extends PageUtils implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;


	private String baggingAddress;
	private String skuCode;
	private String epc;
	 private String orderNo;
     private String productOrderNo;
     private String color;
     private String size;
     private String sampleCode;
     private String createTimeStart;
     private String createTimeEnd;

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductOrderNo() {
		return productOrderNo;
	}
	public void setProductOrderNo(String productOrderNo) {
		this.productOrderNo = productOrderNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSampleCode() {
		return sampleCode;
	}
	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}
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
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	
	
}
