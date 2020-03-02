package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.common.model.PageUtils;
import com.nssol.model.TMetalcheck;
import com.nssol.model.T_Bagging;;

public class TMetalcheckResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<TMetalcheck> metalcheckList;

	public List<TMetalcheck> getMetalcheckList() {
		return metalcheckList;
	}

	public void setMetalcheckList(List<TMetalcheck> metalcheckList) {
		this.metalcheckList = metalcheckList;
	}

}
