package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class T_DO_INFO implements Serializable {

	private static final long serialVersionUID = -1960430607624522491L;

	private String orderNo;

	private int revisionNo;

	private String dONo;

	private String productOrderNo;

	private String documentStatus;


	private String itemCode;

	private String item;

	private Date eTAWH;

	private String transportationMethod;

	private String shiptoPortCode;

	private String shiptoPort;

	private String warehouse;

	private Date contractedETD;

	private int isDel;

	private String creater;

	private String createTime;

	private String modifyer;

	private Timestamp modifyTime;

	private Timestamp importTime;

	T_DO_INFO(){
		importTime = new Timestamp(System.currentTimeMillis());
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getRevisionNo() {
		return revisionNo;
	}

	public void setRevisionNo(int revisionNo) {
		this.revisionNo = revisionNo;
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

	public Date geteTAWH() {
		return eTAWH;
	}

	public void seteTAWH(Date eTAWH) {
		this.eTAWH = eTAWH;
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

	public String getTransportationMethod() {
		return transportationMethod;
	}

	public void setTransportationMethod(String transportationMethod) {
		this.transportationMethod = transportationMethod;
	}

	public String getShiptoPortCode() {
		return shiptoPortCode;
	}

	public void setShiptoPortCode(String shiptoPortCode) {
		this.shiptoPortCode = shiptoPortCode;
	}

	public String getShiptoPort() {
		return shiptoPort;
	}

	public void setShiptoPort(String shiptoPort) {
		this.shiptoPort = shiptoPort;
	}


	public String  getdONo() {
		return dONo;
	}

	public void setdONo(String dONo) {
		this.dONo = dONo;
	}

	public String getProductOrderNo() {
		return productOrderNo;
	}

	public void setProductOrderNo(String productOrderNo) {
		this.productOrderNo = productOrderNo;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public Date getContractedETD() {
		return contractedETD;
	}

	public void setContractedETD(Date contractedETD) {
		this.contractedETD = contractedETD;
	}
}
