package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class T_SET_DETAIL implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4835727847525265427L;
	
	private String orderNo;
	
	private String dONo;

	private String setCode;

	private String setDetailNo;

	private int quantity;

	private String ColorCode;

	private String Color;

	private String patternDimensionCode;

	private String sizeCode;
	
	private String size;

	private BigDecimal qtyPerSet;

	private BigDecimal pickingUnit;

	private int isDel;

	private String creater;

	private String createTime;
	
	private String Deleter;
	
	private Timestamp DeleteTime;

	private String modifyer;

	private Timestamp modifyTime;

	private Timestamp importTime;
	
	T_SET_DETAIL(){
		importTime = new Timestamp(System.currentTimeMillis());
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getdONo() {
		return dONo;
	}

	public void setdONo(String dONo) {
		this.dONo = dONo;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public String getSetDetailNo() {
		return setDetailNo;
	}

	public void setSetDetailNo(String setDetailNo) {
		this.setDetailNo = setDetailNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColorCode() {
		return ColorCode;
	}

	public void setColorCode(String colorCode) {
		ColorCode = colorCode;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getPatternDimensionCode() {
		return patternDimensionCode;
	}

	public void setPatternDimensionCode(String patternDimensionCode) {
		this.patternDimensionCode = patternDimensionCode;
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

	public BigDecimal getQtyPerSet() {
		return qtyPerSet;
	}

	public void setQtyPerSet(BigDecimal qtyPerSet) {
		this.qtyPerSet = qtyPerSet;
	}

	public BigDecimal getPickingUnit() {
		return pickingUnit;
	}

	public void setPickingUnit(BigDecimal pickingUnit) {
		this.pickingUnit = pickingUnit;
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

	public String getDeleter() {
		return Deleter;
	}

	public void setDeleter(String deleter) {
		Deleter = deleter;
	}

	public Timestamp getDeleteTime() {
		return DeleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		DeleteTime = deleteTime;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
