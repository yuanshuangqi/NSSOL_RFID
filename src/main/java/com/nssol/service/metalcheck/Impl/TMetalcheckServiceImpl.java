package com.nssol.service.metalcheck.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.nssol.dao.master.*;
import com.nssol.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.service.metalcheck.TMetalcheckService;

@Service
@Transactional
public class TMetalcheckServiceImpl implements TMetalcheckService {

	@Autowired
	private TMetalcheckDao metalDao;
	@Autowired
	private TOrderDetailDao orderDetailDao;
	@Autowired
	private TMetalcheckDetailDao metalDetailDao;
	@Autowired
	private TMetalcheckSensitivityDao metalcheckSensitivityDao;
	@Autowired
	private TBasicInfoDao basicInfoDao;

	@Override
	public TOrderDetail getOrderDetailAutoBySkuCode(TMetalcheck tMetalcheck) {

		// EPC插入
		Boolean isEpcExists=false;
		// 创建时间
		Date date=new Date();
		java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
		
		// 通过sku查询对应最新PO信息
	    TOrderDetail tOrdDetail =new TOrderDetail();
		tOrdDetail.setSkuCode(tMetalcheck.getSkuCode());
		tOrdDetail.setOrderNo(tMetalcheck.getOrderNo());
		
		// 查询
		TOrderDetail orderDetail = orderDetailDao.selectByskuCode(tOrdDetail);
	
		if(orderDetail!=null) {

		// 获取最新的PO
		String newOrderNo=orderDetail.getOrderNo();
		String newDetailNo=orderDetail.getDetailNo();
		String skuCode=tMetalcheck.getSkuCode();
		String baggingAdd=tMetalcheck.getBaggingAddress();
		Double sensitivity=tMetalcheck.getSensitivity();
		
		if(newOrderNo.length()>0)
		{
			// 判断epc是否存在
			TMetalcheckDetail metalcheckSearch=new TMetalcheckDetail();
			metalcheckSearch.setRfid(tMetalcheck.getEpc());
			TMetalcheckDetail metalcheckIsExist=metalDetailDao.selectByEpc(metalcheckSearch);
			if(metalcheckIsExist!=null && metalcheckIsExist.getRfid().length()>0) {
				isEpcExists=true;
			}
			if(!isEpcExists) {
				orderDetail.setScanNum(1);
				// 查询当前SKU是否已经存在
				TMetalcheck tempMetalcheck=new TMetalcheck();
				tempMetalcheck.setOrderNo(newOrderNo);
				tempMetalcheck.setSkuCode(skuCode);
				tempMetalcheck.setBaggingAddress(baggingAdd);
				tempMetalcheck.setScanTime(date);
				TMetalcheck baggingId = metalDao.selectIdBysku(tempMetalcheck);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(baggingId!=null && baggingId.getDetailNo().length() > 0) {
					tMetalcheck.setCreater(tMetalcheck.getCreater());
					tMetalcheck.setCreateTime(sdf.format(dateTime));
					tMetalcheck.setScanTime(date);
					tMetalcheck.setDetailNo(newDetailNo);
					tMetalcheck.setOrderNo(newOrderNo);
					tMetalcheck.setBaggingAddress(baggingAdd);
					metalDao.updateMetalcheck(tMetalcheck);
		
				}else {
					tMetalcheck.setCreater(tMetalcheck.getCreater());
					tMetalcheck.setCreateTime(sdf.format(dateTime));
					tMetalcheck.setDetailNo(newDetailNo);
					tMetalcheck.setScanTime(date);
					tMetalcheck.setOrderNo(newOrderNo);
					tMetalcheck.setBaggingAddress(baggingAdd);
					tMetalcheck.setScanNum(1);
					metalDao.insertMetalcheck(tMetalcheck); 
				}
	

				 TMetalcheckDetail metalcheckDetail=new TMetalcheckDetail();
				 metalcheckDetail.setCreater(tMetalcheck.getCreater());
				 metalcheckDetail.setBaggingAddress(baggingAdd);
				 metalcheckDetail.setSensitivity(sensitivity);
				 metalcheckDetail.setOrderNo(newOrderNo);
				 metalcheckDetail.setSkuCode(skuCode);
				 metalcheckDetail.setDetailNo(newDetailNo);
				 metalcheckDetail.setCreateTime(dateTime);
				 metalcheckDetail.setRfid(tMetalcheck.getEpc());
				 metalcheckDetail.setSensitivity(tMetalcheck.getSensitivity());
				 metalDetailDao.insertMetalcheckDetail(metalcheckDetail);

				TBasicInfo basicInfo = new TBasicInfo();
				basicInfo.setType("HashimaFlg");
				if(basicInfoDao.getBasicInfo(basicInfo)!=null&&basicInfoDao.getBasicInfo(basicInfo).getValue().equals("Yes")){
					//检针标准表新增
					TMetalcheckSensitivity metalcheckSensitivity = new TMetalcheckSensitivity();
					metalcheckSensitivity = metalcheckSensitivityDao.selectLatestSensitivity(tMetalcheck);
					if(metalcheckSensitivity==null||!tMetalcheck.getSensitivity().equals(metalcheckSensitivity.getSensitivity())){
						metalcheckSensitivityDao.insertMetalcheckSensitivity(tMetalcheck);
					}
					else{
						metalcheckSensitivityDao.updateMetalcheckSensitivity(metalcheckSensitivity);
					}
				}

			}
			else {
				orderDetail.setScanNum(0);
			}
			
			 
		}
	}
		 return orderDetail;
	}
	

	@Override
	public List<TMetalcheck> getMetalcheckByToday(TMetalcheck bag) {
		Date date=new Date();
		TMetalcheck tempSearchBag=new TMetalcheck();
		tempSearchBag.setScanTime(date);
		tempSearchBag.setBaggingAddress(bag.getBaggingAddress());
		List<TMetalcheck> bagList = metalDao.selectByCriteria(tempSearchBag);

		return bagList;
	}
	
	public void insertMetalcheck(TMetalcheck tInspection) {
		metalDao.insertMetalcheck(tInspection);
	}
	
	public void getSaveMetalCheckList(List<TMetalcheck> metailcheckList) {

		 // 按时间顺序
        Collections.sort(metailcheckList, new Comparator<TMetalcheck>() {
            public int compare(TMetalcheck arg0, TMetalcheck arg1) {
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String hits0 = arg0.getCreateTime();
                
                String hits1 = arg1.getCreateTime();
                try {
					if (sdf.parse(hits0).getTime() > sdf.parse(hits1).getTime()) {
					    return 1;
					} else if (sdf.parse(hits0).getTime() == sdf.parse(hits1).getTime()) {
					    return 0;
					} else {
					    return -1;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return -1;
				}
            }
        });


		for(TMetalcheck teamMetal:metailcheckList) {
			// 创建时间
			Date date=new Date();
			java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
			// 判断epc是否存在
			TMetalcheckDetail metalSearch=new TMetalcheckDetail();
			metalSearch.setRfid(teamMetal.getEpc());
		    TMetalcheckDetail MetalIsExist=metalDetailDao.selectByEpc(metalSearch);
					if(MetalIsExist!=null && MetalIsExist.getRfid().length()>0) {
						continue;
					}
					
			 // 查询当天SKU是否已经存在
			TMetalcheck tempSkuIsExist=new TMetalcheck();
			tempSkuIsExist.setOrderNo(teamMetal.getOrderNo());
			tempSkuIsExist.setSkuCode(teamMetal.getSkuCode());
			tempSkuIsExist.setBaggingAddress(teamMetal.getBaggingAddress());
			tempSkuIsExist.setScanTime(date);
			TMetalcheck metalSku = metalDao.selectIdBysku(tempSkuIsExist);
			
			//teamMetal.setCreateTime(teamMetal.);
			teamMetal.setScanTime(date);
			if(metalSku!=null && metalSku.getDetailNo().length() > 0) {
				metalDao.updateMetalcheck(teamMetal);
			}else {
				teamMetal.setScanNum(1);
				metalDao.insertMetalcheck(teamMetal); 
			}
			
			// 明细新增
			 TMetalcheckDetail metalcheckDetail=new TMetalcheckDetail();
			 metalcheckDetail.setCreater(teamMetal.getCreater());
			 metalcheckDetail.setBaggingAddress(teamMetal.getBaggingAddress());
			 metalcheckDetail.setOrderNo(teamMetal.getOrderNo());
			 metalcheckDetail.setSkuCode(teamMetal.getSkuCode());
			 metalcheckDetail.setDetailNo(teamMetal.getDetailNo());
			 metalcheckDetail.setCreateTime(dateTime);
			 metalcheckDetail.setRfid(teamMetal.getEpc());
			 metalDetailDao.insertMetalcheckDetail(metalcheckDetail);

		}
	}
	
	
	
	public List<TMetalcheck> getMetalcheckPage(TMetalcheck bag) {
		
		// 获取总条数
		List<TMetalcheck> bagging=metalDao.selectMetalchecklistCount(bag);
		Integer startNum=(bag.getCurrentPageNumber() - 1) * bag.getCurrentPageShowCounts();
		Integer endNum=bag.getCurrentPageShowCounts() * bag.getCurrentPageNumber();
		
		bag.setStartRecord(startNum);
		bag.setEndRecord(endNum);
		List<TMetalcheck> bagList = metalDao.selectMetalchecklist(bag);
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
	
    public List<TMetalcheck> getMetalcheckList(TMetalcheck bag) {	
		List<TMetalcheck> bagList = metalDao.selectTotMetalchecklist(bag);  
		return bagList;
	}
	public List<TMetalcheckSensitivity> getSensitivityList(TMetalcheck tMetalcheck){
		List<TMetalcheckSensitivity> SensitivityList = metalcheckSensitivityDao.selectSensitivityList(tMetalcheck);
		return SensitivityList;
	}

	public  void deleteMetalcheckData(){
		metalDao.deleteMetalcheckData();
	}

}
