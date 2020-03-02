package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class T_ORDER_DETAIL implements Serializable {

	private static final long serialVersionUID = 1583884589235359461L;

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

	private String sKUCode;

	private String sKUCodeForShipping;

	private BigDecimal orderQty_Pcs;

	private int isDel;

	private String creater;

	private String createTime;

	private String modifyer;

	private Timestamp modifyTime;

	private Timestamp importTime;

	T_ORDER_DETAIL() {
		importTime = new Timestamp(System.currentTimeMillis());
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
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

	public String getsKUCode() {
		return sKUCode;
	}

	public void setsKUCode(String sKUCode) {
		this.sKUCode = sKUCode;
	}

	public String getsKUCodeForShipping() {
		return sKUCodeForShipping;
	}

	public void setsKUCodeForShipping(String sKUCodeForShipping) {
		this.sKUCodeForShipping = sKUCodeForShipping;
	}

	public BigDecimal getOrderQty_Pcs() {
		return orderQty_Pcs;
	}

	public void setOrderQty_Pcs(BigDecimal orderQty_Pcs) {
		this.orderQty_Pcs = orderQty_Pcs;
	}
}