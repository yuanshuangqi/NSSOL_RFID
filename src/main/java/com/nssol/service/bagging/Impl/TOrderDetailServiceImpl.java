package com.nssol.service.bagging.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TOrderDetailDao;
import com.nssol.model.TOrderDetail;
import com.nssol.service.bagging.TOrderDetailService;

@Service
@Transactional
public class TOrderDetailServiceImpl implements TOrderDetailService {

	@Autowired
	private TOrderDetailDao orderDetailDao;

	@Override
	public TOrderDetail getOrderDetailBySku(TOrderDetail tOrdDetail) {

		TOrderDetail orderDetail = orderDetailDao.selectByskuCode(tOrdDetail);
		return orderDetail;
	}
	
	public List<TOrderDetail> getOrderDetailListBysku(TOrderDetail tOrdDetail) {

		List<TOrderDetail> orderDetailList = orderDetailDao.selectOrderDetailBysku(tOrdDetail);
		return orderDetailList;
	}
	
	public List<TOrderDetail> getSkuListByOrderNo(TOrderDetail tOrdDetail) {

		List<TOrderDetail> orderDetailList = orderDetailDao.selectSkuListByOrderNo(tOrdDetail);
		return orderDetailList;
	}
	
	public TOrderDetail getOrderDetailListByPoSku(TOrderDetail tOrdDetail) {
		List<TOrderDetail> orderDetailList = orderDetailDao.selectOrderDetailBysku(tOrdDetail);
		if(orderDetailList!=null && orderDetailList.size()>0) {
			return orderDetailList.get(0);
		}
		return null;
	}
}
