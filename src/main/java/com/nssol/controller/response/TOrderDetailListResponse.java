package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.model.TOrderDetail;

public class TOrderDetailListResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<TOrderDetail> orderDetailList;

	public List<TOrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<TOrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
}
