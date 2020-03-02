package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.model.PageUtils;

public class T_Tagging extends PageUtils implements Serializable {

	private static final long serialVersionUID = 7579990050219013455L;

	private String orderNo;
	private String detailNo;

	private String colorCode;

	private String color;

	private String sizeCode;

	private String size;

	private String patternDimensionCode;

	private String sampleCode;

	private String itemCode;

	private String item;

	private String skuCode;

	private String sKUCodeForShipping;

	private String taggingAddress;

	private Date scanTime;

	private int scanNum;

	private String iCCard;

	private int isDel;

	private String userID;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String creater;

	private Timestamp createTime;

	private String modifyer;

	private Timestamp modifyTime;

	private String epc;

	private Integer startRecord;

	private Integer endRecord;

	private String createTimeStart;
	private String createTimeEnd;
	private String businessUnit;

	private String itemBrand;
	private String productOrderNo;

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

	public String getsKUCodeForShipping() {
		return sKUCodeForShipping;
	}

	public void setsKUCodeForShipping(String sKUCodeForShipping) {
		this.sKUCodeForShipping = sKUCodeForShipping;
	}

	public String getTaggingAddress() {
		return taggingAddress;
	}

	public void setTaggingAddress(String taggingAddress) {
		this.taggingAddress = taggingAddress;
	}

	public Date getScanTime() {
		return scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}

	public int getScanNum() {
		return scanNum;
	}

	public void setScanNum(int scanNum) {
		this.scanNum = scanNum;
	}

	public String getiCCard() {
		return iCCard;
	}

	public void setiCCard(String iCCard) {
		this.iCCard = iCCard;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCreater() {
		return userID;
	}

	public void setCreater(String creater) {
		this.creater = userID;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
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

	public String getEpc() {
		return epc;
	}

	public void setEpc(String epc) {
		this.epc = epc;
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

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getProductOrderNo() {
		return productOrderNo;
	}

	public void setProductOrderNo(String productOrderNo) {
		this.productOrderNo = productOrderNo;
	}

	public Double getOrderQty_Pcs() {
		return orderQty_Pcs;
	}

	public void setOrderQty_Pcs(Double orderQty_Pcs) {
		this.orderQty_Pcs = orderQty_Pcs;
	}

	private Double orderQty_Pcs;

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
}
