package com.nssol.model;

import java.io.Serializable;
import java.util.Date;

public class Role_Resource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3732616955191918323L;
	
	private String fkRoleCode;
	
	private String fkPageNo;
	
	private String fkFunctionNo;
	
	private String creater;
	
	private Date createTime;
	
	private String modifyer;
	
	private Date modifyTime;

	public String getFkRoleCode() {
		return fkRoleCode;
	}

	public void setFkRoleCode(String fkRoleCode) {
		this.fkRoleCode = fkRoleCode;
	}

	public String getFkPageNo() {
		return fkPageNo;
	}

	public void setFkPageNo(String fkPageNo) {
		this.fkPageNo = fkPageNo;
	}

	public String getFkFunctionNo() {
		return fkFunctionNo;
	}

	public void setFkFunctionNo(String fkFunctionNo) {
		this.fkFunctionNo = fkFunctionNo;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
