package com.nssol.controller.response;

import com.nssol.model.TMetalcheckDetail;
import com.nssol.model.TMetalcheckSensitivity;

import java.io.Serializable;
import java.util.List;

;

public class TSensitivityResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<TMetalcheckSensitivity> metalcheckSensitivityList;


	public void setMetalcheckSensitivityList(List<TMetalcheckSensitivity> metalcheckSensitivityList) {
		this.metalcheckSensitivityList = metalcheckSensitivityList;
	}

	public List<TMetalcheckSensitivity> getMetalcheckSensitivityList() {
		return metalcheckSensitivityList;
	}
}
