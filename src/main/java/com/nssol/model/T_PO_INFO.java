package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class T_PO_INFO implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

	private String orderNo;
	
	private int revisionNo;

	private int year;

	private String planningSsn;

	private String globalBusinessUnit;

	private String businessUnit;

	private String itemBrand;

	private String department;

	private String documentStatus;

	private String answeredStatus;

	private String orderPlanNumber;

	private String sampleCode;

	private String itemCode;

	private String item;

	private String managementFactoryCode;

	private String managementFactory;

	private String branchFactoryCode;

	private String branchFactory;

	private Date contractedETD;

	private Date eTAWH;

	private int isDel;

	private String creater;

	private String createTime;

	private String modifyer;

	private Timestamp modifyTime;


	private Timestamp importTime;

	T_PO_INFO(){
		importTime = new Timestamp(System.currentTimeMillis());
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public String getPlanningSsn() {
		return planningSsn;
	}

	public void setPlanningSsn(String planningSsn) {
		this.planningSsn = planningSsn;
	}

	public String getGlobalBusinessUnit() {
		return globalBusinessUnit;
	}

	public void setGlobalBusinessUnit(String globalBusinessUnit) {
		this.globalBusinessUnit = globalBusinessUnit;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getAnsweredStatus() {
		return answeredStatus;
	}

	public void setAnsweredStatus(String answeredStatus) {
		this.answeredStatus = answeredStatus;
	}

	public String getOrderPlanNumber() {
		return orderPlanNumber;
	}

	public void setOrderPlanNumber(String orderPlanNumber) {
		this.orderPlanNumber = orderPlanNumber;
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

	public String getManagementFactoryCode() {
		return managementFactoryCode;
	}

	public void setManagementFactoryCode(String managementFactoryCode) {
		this.managementFactoryCode = managementFactoryCode;
	}

	public String getManagementFactory() {
		return managementFactory;
	}

	public void setManagementFactory(String managementFactory) {
		this.managementFactory = managementFactory;
	}

	public String getBranchFactoryCode() {
		return branchFactoryCode;
	}

	public void setBranchFactoryCode(String branchFactoryCode) {
		this.branchFactoryCode = branchFactoryCode;
	}

	public String getBranchFactory() {
		return branchFactory;
	}

	public void setBranchFactory(String branchFactory) {
		this.branchFactory = branchFactory;
	}

	public Date getContractedETD() {
		return contractedETD;
	}

	public void setContractedETD(Date contractedETD) {
		this.contractedETD = contractedETD;
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


}
