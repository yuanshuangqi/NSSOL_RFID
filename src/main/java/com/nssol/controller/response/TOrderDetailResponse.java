package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Bagging;

public class TOrderDetailResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private TOrderDetail orderDetail;

	public TOrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(TOrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	

}
