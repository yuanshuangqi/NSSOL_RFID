package com.nssol.service.tagging.Impl;

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
import com.nssol.dao.master.TOrderDetailDao;
import com.nssol.dao.master.TTaggingDao;
import com.nssol.dao.master.TTaggingDetailDao;
import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Tagging;
import com.nssol.model.TTaggingDetail;
import com.nssol.service.tagging.TTaggingService;

@Service
@Transactional
public class TTaggingServiceImpl implements TTaggingService {

	@Autowired
	private TTaggingDao tagDao;
	@Autowired
	private TOrderDetailDao orderDetailDao;
	
	@Autowired
	private TTaggingDetailDao taggingDetailDao;


	@Override
	public List<T_Tagging> getTaggingByToday(T_Tagging tag) {
		Date date=new Date();
		T_Tagging tempSearchTag=new T_Tagging();
		tempSearchTag.setScanTime(date);
		tempSearchTag.setUserID(tag.getUserID());
		List<T_Tagging> tagList = tagDao.selectByCriteria(tempSearchTag);
		
		
		return tagList;
	}
	
	public void insertTagging(T_Tagging tTagging) {
		tagDao.insertTagging(tTagging);
	}
	
	public TOrderDetail getOrderDetailBySkuCode(T_Tagging tTagging) {

		// EPC插入
		Boolean isEpcExists=false;
		// 创建时间
		Date date=new Date();
		java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
		
		// 通过sku查询对应最新PO信息
	    TOrderDetail tOrdDetail =new TOrderDetail();
		tOrdDetail.setSkuCode(tTagging.getSkuCode());
		
		// 查询
		TOrderDetail orderDetail = orderDetailDao.selectByskuCode(tOrdDetail);
	
		if(orderDetail!=null) {

		// 获取最新的PO
		String newOrderNo=orderDetail.getOrderNo();
		String newDetailNo=orderDetail.getDetailNo();
		String skuCode=tTagging.getSkuCode();
		String taggingAdd=tTagging.getTaggingAddress();
		
		if(newOrderNo.length()>0)
		{
			// 判断epc是否存在
			TTaggingDetail tagDetailSearch=new TTaggingDetail();
			tagDetailSearch.setRfid(tTagging.getEpc());
			TTaggingDetail tagDetailIsExist=taggingDetailDao.selectByEpc(tagDetailSearch);
			if(tagDetailIsExist!=null && tagDetailIsExist.getRfid().length()>0) {
				isEpcExists=true;
			}
			if(!isEpcExists) {
				orderDetail.setScanNum(1);
				// 查询当前SKU是否已经存在
				T_Tagging tempTag=new T_Tagging();
				tempTag.setOrderNo(newOrderNo);
				tempTag.setSkuCode(skuCode);
				tempTag.setTaggingAddress(taggingAdd);
				tempTag.setScanTime(date);
				T_Tagging taggingId = tagDao.selectIdBysku(tempTag);
	
				if(taggingId!=null && taggingId.getDetailNo().length() > 0) {
					tTagging.setCreater(tTagging.getCreater());
					tTagging.setCreateTime(dateTime);
					tTagging.setScanTime(date);
					tTagging.setDetailNo(newDetailNo);
					tTagging.setOrderNo(newOrderNo);
					tTagging.setTaggingAddress(taggingAdd);
					tagDao.updateTagging(tTagging);
		
				}else {
					tTagging.setCreater(tTagging.getCreater());
					tTagging.setCreateTime(dateTime);
					tTagging.setDetailNo(newDetailNo);
					tTagging.setScanTime(date);
					tTagging.setOrderNo(newOrderNo);
					tTagging.setTaggingAddress(taggingAdd);
					tTagging.setScanNum(1);
					tagDao.insertTagging(tTagging); 
				}
	

				 TTaggingDetail tagDetail=new TTaggingDetail();
				 tagDetail.setUserID(tTagging.getUserID());
				 tagDetail.setCreater(tTagging.getCreater());
				 tagDetail.setTaggingAddress(taggingAdd);
				 tagDetail.setOrderNo(newOrderNo);
				 tagDetail.setSkuCode(skuCode);
				 tagDetail.setDetailNo(newDetailNo);
				 tagDetail.setCreateTime(dateTime);
				 tagDetail.setRfid(tTagging.getEpc());
				 taggingDetailDao.insertTaggingDetail(tagDetail);
			}
			else {
				orderDetail.setScanNum(0);
			}
			
			 
		}
	}
		 return orderDetail;
	}
	
	
	
	public List<T_Tagging> getTaggingListPage(T_Tagging tag) {
		
		// 获取总条数
		List<T_Tagging> tagging=tagDao.selectTagginglistCount(tag);
		Integer startNum=(tag.getCurrentPageNumber() - 1) * tag.getCurrentPageShowCounts();
		Integer endNum=tag.getCurrentPageShowCounts() * tag.getCurrentPageNumber();
		
		tag.setStartRecord(startNum);
		tag.setEndRecord(endNum);
		List<T_Tagging> tagList = tagDao.selectTagginglist(tag);
		Integer recoreCounts =0;
		if(tagging!=null && !tagging.isEmpty()) {
			recoreCounts=tagging.size();
		}
		Integer pageCounts= (recoreCounts + tag.getCurrentPageShowCounts() - 1) / tag.getCurrentPageShowCounts();
		if(recoreCounts>0)
		{
			if(tag.getCurrentPageShowCounts()<=0) {
				tagList.get(0).setPagesCount(0);
			}else {
				tagList.get(0).setPagesCount(pageCounts);
			}
			if(tag.getCurrentPageNumber()<pageCounts) {
				tagList.get(0).setCurrentPageRecordCounts(tag.getCurrentPageShowCounts());
			}else {
				tagList.get(0).setCurrentPageRecordCounts(recoreCounts % tag.getCurrentPageShowCounts());
			}
			 if (tagList.get(0).getCurrentPageRecordCounts() == 0) {
				 tagList.get(0).setCurrentPageRecordCounts (tag.getCurrentPageShowCounts());
			 }
			tagList.get(0).setRecordCounts(recoreCounts);
			tagList.get(0).setCurrentPageShowCounts(tag.getCurrentPageShowCounts());
			tagList.get(0).setCurrentPageNumber(tag.getCurrentPageNumber());
		}
		return tagList;
	}
	
    public List<T_Tagging> getTaggingList(T_Tagging tag) {	
		List<T_Tagging> tagList = tagDao.selectTotTagginglist(tag);  
		return tagList;
	}
}
