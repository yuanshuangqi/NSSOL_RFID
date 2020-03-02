package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.model.TBasicInfo;
import com.nssol.model.TMstDictionary;

public class TBasicInfoResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<TBasicInfo> basicInfoList;

	public List<TBasicInfo> getBasicInfoList() {
		return basicInfoList;
	}

	public void setBasicInfoList(List<TBasicInfo> basicInfoList) {
		this.basicInfoList = basicInfoList;
	}
}
