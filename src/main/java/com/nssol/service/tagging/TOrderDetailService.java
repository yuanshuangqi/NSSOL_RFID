package com.nssol.service.tagging;


import java.util.List;

import com.nssol.model.TOrderDetail;

public interface TOrderDetailService {

	public TOrderDetail getOrderDetailBySku(TOrderDetail orderDetail) ;
	
	public List<TOrderDetail> getOrderDetailListBysku(TOrderDetail tOrdDetail);
	
	public List<TOrderDetail> getSkuListByOrderNo(TOrderDetail tOrdDetail);
	
	public TOrderDetail getOrderDetailListByPoSku(TOrderDetail tOrdDetail);
}
