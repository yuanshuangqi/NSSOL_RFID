package com.nssol.model;

import java.io.Serializable;
import java.util.List;

public class Module_Info extends Page_Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1339975660688735347L;
	
	private String moduleNo;
	
	private String moduleName;
	
	private List<Page_Info> lsPageInfo;

	public String getModuleNo() {
		return moduleNo;
	}

	public void setModuleNo(String moduleNo) {
		this.moduleNo = moduleNo;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<Page_Info> getLsPageInfo() {
		return lsPageInfo;
	}

	public void setLsPageInfo(List<Page_Info> lsPageInfo) {
		this.lsPageInfo = lsPageInfo;
	}
	
}
