package com.nssol.service.bagging.Impl;

import java.security.Timestamp;
import java.security.cert.CertPath;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.common.model.PageUtils;
import com.nssol.dao.master.TBaggingDao;
import com.nssol.dao.master.TBaggingDetailDao;
import com.nssol.dao.master.TOrderDetailDao;
import com.nssol.model.TBaggingDetail;
import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Bagging;
import com.nssol.service.bagging.TBaggingService;

@Service
@Transactional
public class TBaggingServiceImpl implements TBaggingService {

	@Autowired
	private TBaggingDao bagDao;
	@Autowired
	private TOrderDetailDao orderDetailDao;
	
	@Autowired
	private TBaggingDetailDao baggingDetailDao;


	@Override
	public List<T_Bagging> getBaggingByToday(T_Bagging bag) {
		Date date=new Date();
		T_Bagging tempSearchBag=new T_Bagging();
		tempSearchBag.setScanTime(date);
		tempSearchBag.setBaggingAddress(bag.getBaggingAddress());
		List<T_Bagging> bagList = bagDao.selectByCriteria(tempSearchBag);
		
		
		return bagList;
	}
	
	public void insertBagging(T_Bagging tBagging) {
		bagDao.insertBagging(tBagging);
	}
	
	public TOrderDetail getOrderDetailBySkuCode(T_Bagging tBagging) {

		// EPC插入
		Boolean isEpcExists=false;
		// 创建时间
		Date date=new Date();
		java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
		
		// 通过sku查询对应最新PO信息
	    TOrderDetail tOrdDetail =new TOrderDetail();
		tOrdDetail.setSkuCode(tBagging.getSkuCode());
		
		// 查询
		TOrderDetail orderDetail = orderDetailDao.selectByskuCode(tOrdDetail);
	
		if(orderDetail!=null) {

		// 获取最新的PO
		String newOrderNo=orderDetail.getOrderNo();
		String newDetailNo=orderDetail.getDetailNo();
		String skuCode=tBagging.getSkuCode();
		String baggingAdd=tBagging.getBaggingAddress();
		
		if(newOrderNo.length()>0)
		{
			// 判断epc是否存在
			TBaggingDetail bagDetailSearch=new TBaggingDetail();
			bagDetailSearch.setRfid(tBagging.getEpc());
			TBaggingDetail bagDetailIsExist=baggingDetailDao.selectByEpc(bagDetailSearch);
			if(bagDetailIsExist!=null && bagDetailIsExist.getRfid().length()>0) {
				isEpcExists=true;
			}
			if(!isEpcExists) {
				orderDetail.setScanNum(1);
				// 查询当前SKU是否已经存在
				T_Bagging tempBag=new T_Bagging();
				tempBag.setOrderNo(newOrderNo);
				tempBag.setSkuCode(skuCode);
				tempBag.setBaggingAddress(baggingAdd);
				tempBag.setScanTime(date);
				T_Bagging baggingId = bagDao.selectIdBysku(tempBag);
	
				if(baggingId!=null && baggingId.getDetailNo().length() > 0) {
					tBagging.setCreater(tBagging.getCreater());
					tBagging.setCreateTime(dateTime);
					tBagging.setScanTime(date);
					tBagging.setDetailNo(newDetailNo);
					tBagging.setOrderNo(newOrderNo);
					tBagging.setBaggingAddress(baggingAdd);
					bagDao.updateBagging(tBagging);
		
				}else {
					tBagging.setCreater(tBagging.getCreater());
					tBagging.setCreateTime(dateTime);
					tBagging.setDetailNo(newDetailNo);
					tBagging.setScanTime(date);
					tBagging.setOrderNo(newOrderNo);
					tBagging.setBaggingAddress(baggingAdd);
					tBagging.setScanNum(1);
					bagDao.insertBagging(tBagging); 
				}
	

				 TBaggingDetail bagDetail=new TBaggingDetail();
				 bagDetail.setCreater(tBagging.getCreater());
				 bagDetail.setBaggingAddress(baggingAdd);
				 bagDetail.setOrderNo(newOrderNo);
				 bagDetail.setSkuCode(skuCode);
				 bagDetail.setDetailNo(newDetailNo);
				 bagDetail.setCreateTime(dateTime);
				 bagDetail.setRfid(tBagging.getEpc());
				 baggingDetailDao.insertBaggingDetail(bagDetail);
			}
			else {
				orderDetail.setScanNum(0);
			}
			
			 
		}
	}
		 return orderDetail;
	}
	
	
	
	public List<T_Bagging> getBaggingListPage(T_Bagging bag) {
		
		// 获取总条数
		List<T_Bagging> bagging=bagDao.selectBagginglistCount(bag);
		Integer startNum=(bag.getCurrentPageNumber() - 1) * bag.getCurrentPageShowCounts();
		Integer endNum=bag.getCurrentPageShowCounts() * bag.getCurrentPageNumber();
		
		bag.setStartRecord(startNum);
		bag.setEndRecord(endNum);
		List<T_Bagging> bagList = bagDao.selectBagginglist(bag);
		Integer recoreCounts =0;
		if(bagging!=null && !bagging.isEmpty()) {
			recoreCounts=bagging.size();
		}
		Integer pageCounts= (recoreCounts + bag.getCurrentPageShowCounts() - 1) / bag.getCurrentPageShowCounts();
		if(recoreCounts>0)
		{
			if(bag.getCurrentPageShowCounts()<=0) {
				bagList.get(0).setPagesCount(0);
			}else {
				bagList.get(0).setPagesCount(pageCounts);
			}
			if(bag.getCurrentPageNumber()<pageCounts) {
				bagList.get(0).setCurrentPageRecordCounts(bag.getCurrentPageShowCounts());
			}else {
				bagList.get(0).setCurrentPageRecordCounts(recoreCounts % bag.getCurrentPageShowCounts());
			}
			 if (bagList.get(0).getCurrentPageRecordCounts() == 0) {
				 bagList.get(0).setCurrentPageRecordCounts (bag.getCurrentPageShowCounts());
			 }
			bagList.get(0).setRecordCounts(recoreCounts);
			bagList.get(0).setCurrentPageShowCounts(bag.getCurrentPageShowCounts());
			bagList.get(0).setCurrentPageNumber(bag.getCurrentPageNumber());
		}
		return bagList;
	}
	
    public List<T_Bagging> getBaggingList(T_Bagging bag) {	
		List<T_Bagging> bagList = bagDao.selectTotBagginglist(bag);  
		return bagList;
	}
}
