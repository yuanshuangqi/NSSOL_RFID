package com.nssol.service.metalcheck;

import java.util.List;

import com.nssol.model.TMetalcheckSensitivity;
import com.nssol.model.TOrderDetail;
import com.nssol.model.TMetalcheck;;

public interface TMetalcheckService {

	public List<TMetalcheck> getMetalcheckByToday(TMetalcheck tMetalcheck) ;
	
	public void insertMetalcheck(TMetalcheck tMetalcheck);
	
	public void getSaveMetalCheckList(List<TMetalcheck> tMetalcheck);
	
	public List<TMetalcheck> getMetalcheckPage(TMetalcheck tMetalcheck);
	
	public List<TMetalcheck> getMetalcheckList(TMetalcheck tMetalcheck);
	
	public TOrderDetail getOrderDetailAutoBySkuCode(TMetalcheck tMetalcheck);

	public List<TMetalcheckSensitivity> getSensitivityList(TMetalcheck tMetalcheck);

	public void deleteMetalcheckData();
}
