package com.nssol.model;

import java.io.Serializable;
import java.util.List;

public class Page_Info extends Function_Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 355573666963873289L;

	private String pageNo;
	
	private String pageName;
	
	private String pageUrl;
	
	private Boolean isPagecheck;
	
	private List<Function_Info> lsFunctionInfo;

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public List<Function_Info> getLsFunctionInfo() {
		return lsFunctionInfo;
	}

	public void setLsFunctionInfo(List<Function_Info> lsFunctionInfo) {
		this.lsFunctionInfo = lsFunctionInfo;
	}

	public Boolean getIsPagecheck() {
		return isPagecheck;
	}

	public void setIsPagecheck(Boolean isPagecheck) {
		this.isPagecheck = isPagecheck;
	}
	
}
