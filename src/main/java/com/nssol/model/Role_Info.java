package com.nssol.model;

import java.io.Serializable;
import java.util.Date;

import com.nssol.common.Page;

public class Role_Info extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5446412406911198990L;

	private String roleCode;
	
	private String roleName;
	
	private String createTime;
	
	private String creater;
	
	private String modifyTime;
	
	private String modifyer;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}

}
