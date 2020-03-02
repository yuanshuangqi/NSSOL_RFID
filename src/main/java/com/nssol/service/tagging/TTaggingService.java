package com.nssol.service.tagging;

import java.util.List;

import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Tagging;;

public interface TTaggingService {

	public List<T_Tagging> getTaggingByToday(T_Tagging tTagging) ;
	
	public void insertTagging(T_Tagging tTagging);
	
	public TOrderDetail getOrderDetailBySkuCode(T_Tagging tTagging);
	
	public List<T_Tagging> getTaggingListPage(T_Tagging tTagging) ;
	
	public List<T_Tagging> getTaggingList(T_Tagging tTagging) ;
}
