package com.nssol.service.bagging;

import java.util.List;

import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Bagging;;

public interface TBaggingService {

	public List<T_Bagging> getBaggingByToday(T_Bagging tBagging) ;
	
	public void insertBagging(T_Bagging tBagging);
	
	public TOrderDetail getOrderDetailBySkuCode(T_Bagging tBagging);
	
	public List<T_Bagging> getBaggingListPage(T_Bagging tBagging) ;
	
	public List<T_Bagging> getBaggingList(T_Bagging tBagging) ;
}
