package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.nssol.common.Page;

public class UserModel extends Page implements Serializable {

	private static final long serialVersionUID = 7579890050219013424L;

	private String userId;

	private String userName;

	private String password;
	
	private int sex;
	
	private String tel;
	
	private String iCCard;
	
	private int isDel;
	
	private String creater;
	
	private Timestamp createTime;
	
	private String modifyer;
	
	private Timestamp modifyTime;
	
	private String deleter;
	
	private Timestamp deleteTime;
	private String realName;
    private String fkRoleCode;
	
	private String roleName;
	
	
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFkRoleCode() {
		return fkRoleCode;
	}

	public void setFkRoleCode(String fkRoleCode) {
		this.fkRoleCode = fkRoleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
	
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
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
	
	public String getDeleter() {
		return deleter;
	}

	public void setDeleter(String deleter) {
		this.deleter = deleter;
	}

	public Timestamp getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
}
