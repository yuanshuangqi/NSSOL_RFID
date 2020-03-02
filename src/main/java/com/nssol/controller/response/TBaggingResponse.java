package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.common.model.PageUtils;
import com.nssol.model.T_Bagging;;

public class TBaggingResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<T_Bagging> baggingList;

	public List<T_Bagging> getBaggingList() {
		return baggingList;
	}

	public void setBaggingList(List<T_Bagging> bagList) {
		this.baggingList = bagList;
	}
}
