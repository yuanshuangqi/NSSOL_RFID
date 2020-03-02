package com.nssol.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TOrderDetail implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;

	private String orderNo;
	private String detailNo;
	private String colorCode;
	private String color;
	private String sizeCode;
	private String size;
	private String patternDimensionCode;
	private String sampleCode;
	private String itemBrand;
	private String itemCode;
	private String item;
	private String skuCode;
	private String skuCodeForShipping;
	private Double orderQty_Pcs;
	private String businessUnit;
    private String epc;
    private Integer scanNum;
    private String etd;
    private String createTimeStart;
    private String createTimeEnd;
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public String getCreateTimeStart() {
		return createTimeStart;
	}
	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public String getEtd() {
		return etd;
	}
	public void setEtd(String etd) {
		this.etd = etd;
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
	public String getSkuCodeForShipping() {
		return skuCodeForShipping;
	}
	public void setSkuCodeForShipping(String skuCodeForShipping) {
		this.skuCodeForShipping = skuCodeForShipping;
	}
	public Double getOrderQty_Pcs() {
		return orderQty_Pcs;
	}
	public void setOrderQty_Pcs(Double orderQty_Pcs) {
		this.orderQty_Pcs = orderQty_Pcs;
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
}
