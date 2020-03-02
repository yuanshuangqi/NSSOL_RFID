package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.model.PageUtils;

public class TMetalcheck extends PageUtils implements Serializable  {

	private static final long serialVersionUID = 7579890050219013454L;

	private String orderNo;
	private String detailNo;
	private String colorCode;
	private String color;
	private String sizeCode;
	private String size;
	private String baggingAddress;
	private Double sensitivity;
	private String patternDimensionCode;
	private String sampleCode;
	private String itemBrand;
	private String itemCode;
	private String item;
	private String skuCode;
	private String createTime;
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	private String productOrderNo;
	private String createTimeStart;
	private String creater;
	private String businessUnit;
	private String epc;
	private Integer scanNum;
	private String createTimeEnd;
	private Integer startRecord;
	private Date scanTime;
	private Double orderQty_Pcs;
	public Double getOrderQty_Pcs() {
		return orderQty_Pcs;
	}
	public void setOrderQty_Pcs(Double orderQty_Pcs) {
		this.orderQty_Pcs = orderQty_Pcs;
	}
	public Date getScanTime() {
		return scanTime;
	}
	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}
	public Integer getStartRecord() {
		return startRecord;
	}
	public void setStartRecord(Integer startRecord) {
		this.startRecord = startRecord;
	}
	public Integer getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(Integer endRecord) {
		this.endRecord = endRecord;
	}
	private Integer endRecord;
	 
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
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSizeCode() {
		return sizeCode;
	}
	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBaggingAddress() {
		return baggingAddress;
	}
	public void setBaggingAddress(String baggingAddress) {
		this.baggingAddress = baggingAddress;
	}
	public String getPatternDimensionCode() {
		return patternDimensionCode;
	}
	public void setPatternDimensionCode(String patternDimensionCode) {
		this.patternDimensionCode = patternDimensionCode;
	}
	public String getSampleCode() {
		return sampleCode;
	}
	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	
	public String getProductOrderNo() {
		return productOrderNo;
	}
	public void setProductOrderNo(String productOrderNo) {
		this.productOrderNo = productOrderNo;
	}
	
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public Integer getScanNum() {
		return scanNum;
	}
	public void setScanNum(Integer scanNum) {
		this.scanNum = scanNum;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public Double getSensitivity() {
		return sensitivity;
	}

	public void setSensitivity(Double sensitivity) {
		this.sensitivity = sensitivity;
	}
}
