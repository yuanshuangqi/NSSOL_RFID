package com.nssol.service.po_import.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.common.Constant;
import com.nssol.dao.cluster.ClusterCBMInfoDao;
import com.nssol.dao.cluster.ClusterDoInfoDao;
import com.nssol.dao.cluster.ClusterOrderDetailDao;
import com.nssol.dao.cluster.ClusterPoInfoDao;
import com.nssol.dao.cluster.ClusterSetDetailDao;
import com.nssol.dao.cluster.ClusterSetInfoDao;
import com.nssol.dao.master.MasterBatchProcessDao;
import com.nssol.dao.master.MasterCBMInfoDao;
import com.nssol.dao.master.MasterDoInfoDao;
import com.nssol.dao.master.MasterOrderDetailDao;
import com.nssol.dao.master.MasterPoInfoDao;
import com.nssol.dao.master.MasterSetDetailDao;
import com.nssol.dao.master.MasterSetInfoDao;
import com.nssol.dao.master.ProcedureDao;
import com.nssol.model.T_BATCH_PROCESS;
import com.nssol.model.T_CBM_INFO;
import com.nssol.model.T_DO_INFO;
import com.nssol.model.T_ORDER_DETAIL;
import com.nssol.model.T_PO_INFO;
import com.nssol.model.T_SET_DETAIL;
import com.nssol.model.T_SET_INFO;
import com.nssol.service.po_import.PoImportService;


@Service
@Transactional
public class PoImportServiceImpl implements PoImportService,Constant {

	@Autowired
	private MasterPoInfoDao masterPoInfoDao;
	
	@Autowired
	private ClusterPoInfoDao clusterPoInfoDao;

	@Autowired
	private MasterDoInfoDao masterDoInfoDao;

	@Autowired
	private ClusterDoInfoDao clusterDoInfoDao;

	@Autowired
	private MasterOrderDetailDao masterOrderDetailDao;

	@Autowired
	private ClusterOrderDetailDao clusterOrderDetailDao;

	@Autowired
	private MasterBatchProcessDao masterBatchProcessDao;
	
	@Autowired
	private MasterSetInfoDao masterSetInfoDao;
	
	@Autowired
	private ClusterSetInfoDao clusterSetInfoDao;
	
	@Autowired
	private MasterSetDetailDao masterSetDetailDao;
	
	@Autowired
	private ClusterSetDetailDao clusterSetDetailDao;
	
	@Autowired 
	private ProcedureDao procedureDao;
	
	@Autowired
	private ClusterCBMInfoDao clusterCBMInfoDao;
	
	@Autowired
	private MasterCBMInfoDao masterCBMInfoDao;
	
	@Override
	public void synBatch(){
		T_BATCH_PROCESS batchProcess = masterBatchProcessDao.getLastTime(PO_IMPORT);
		if(batchProcess==null){
			batchProcess = new T_BATCH_PROCESS(PO_IMPORT);
			batchProcess.setProcess_time(Timestamp.valueOf("1900-01-01 00:00:00"));
		}
		if(batchProcess.getProcess_flag()==0){
			try{
				T_BATCH_PROCESS newBatchProcess = new T_BATCH_PROCESS(PO_IMPORT);
				batchProcess.setProcess_flag(1);
				masterBatchProcessDao.updateProcessFlag(batchProcess);
				List<T_PO_INFO> poList =synPoInfo(batchProcess.getProcess_time());
				if(poList!=null && poList.size()!=0) {
					synDoInfo(batchProcess.getProcess_time());
					synOrderDetail(poList,batchProcess.getProcess_time());
				}
				List<T_SET_INFO> setList =synSetInfo(batchProcess.getProcess_time());
				if(setList!=null && setList.size()!=0) {
					synSetDetail(batchProcess.getProcess_time());
				}
				
				// T_CBM_INFO 信息同步
				synCBMInfo(batchProcess.getProcess_time());
				
				newBatchProcess.setProcess_time(newBatchProcess.getCreateTime());
				masterBatchProcessDao.insert(newBatchProcess);
			}catch (Exception ex){
				throw ex;
			}finally {
				batchProcess.setProcess_flag(0);
				masterBatchProcessDao.updateProcessFlag(batchProcess);
			}

		}
	}

	private List<T_PO_INFO> synPoInfo(Timestamp lastTime) {
		List<T_PO_INFO> poList = clusterPoInfoDao.selectAll(lastTime);
		if(poList!=null && poList.size()!=0) {
			List<T_PO_INFO> list = new ArrayList<T_PO_INFO>();
			int i;
			for (i = 0; i + INSERT_COUNT < poList.size(); i += INSERT_COUNT) {
				list = poList.subList(i, i + INSERT_COUNT);
				masterPoInfoDao.delete(list);
				masterPoInfoDao.insert(list);
			}
			list = poList.subList(i, i + poList.size() % INSERT_COUNT);
			masterPoInfoDao.delete(list);
			masterPoInfoDao.insert(list);
		}
		return poList;
	}
	
	private List<T_SET_INFO> synSetInfo(Timestamp lastTime) {
		List<T_SET_INFO> setList = clusterSetInfoDao.selectSetInfo(lastTime);
		if(setList!=null && setList.size()!=0) {
			List<T_SET_INFO> list = new ArrayList<T_SET_INFO>();
			int i;
			for (i = 0; i + INSERT_COUNT < setList.size(); i += INSERT_COUNT) {
				list = setList.subList(i, i + INSERT_COUNT);
				masterSetInfoDao.deleteSetInfo(list);
				masterSetInfoDao.insertSetInfo(list);
			}
			list = setList.subList(i, i + setList.size() % INSERT_COUNT);
			if(list.size() > 0)
			{
				masterSetInfoDao.deleteSetInfo(list);
				masterSetInfoDao.insertSetInfo(list);
			}
		}
		return setList;
	}

	private void synDoInfo(Timestamp lastTime) {		
		List<T_DO_INFO> doList = clusterDoInfoDao.selectAll(lastTime);
		List<T_DO_INFO> insertList = new ArrayList<T_DO_INFO>();
		int i;
		for(i=0; i+ INSERT_COUNT<doList.size(); i+=INSERT_COUNT){
			insertList = doList.subList(i,i+INSERT_COUNT);
			masterDoInfoDao.delete(insertList);
			masterDoInfoDao.insert(insertList);
		}
		insertList = doList.subList(i,i+doList.size()%INSERT_COUNT);
		
		masterDoInfoDao.delete(insertList);
		masterDoInfoDao.insert(insertList);
	}

	private void synOrderDetail(List<T_PO_INFO> poList, Timestamp lastTime) {
		int j;
		List<T_PO_INFO> deleteList = new ArrayList<T_PO_INFO>();
		for(j=0; j+ 1000<poList.size(); j+=1000){
			deleteList = poList.subList(j,j+1000);
			masterOrderDetailDao.delete(deleteList);
		}
		deleteList = poList.subList(j,j+poList.size()%1000);
		masterOrderDetailDao.delete(deleteList);
		
		List<T_ORDER_DETAIL> orderList = clusterOrderDetailDao.selectAll(lastTime);
		
		List<T_ORDER_DETAIL> insertList = new ArrayList<T_ORDER_DETAIL>();
		int i;
		for(i=0; i+ INSERT_COUNT<orderList.size(); i+=INSERT_COUNT){
			insertList = orderList.subList(i,i+INSERT_COUNT);
			masterOrderDetailDao.insert(insertList);
		}
		insertList = orderList.subList(i,i+orderList.size()%INSERT_COUNT);
		
		if(insertList.size() > 0)
		{
			masterOrderDetailDao.insert(insertList);
		}
	}
	
	private void synSetDetail(Timestamp lastTime) {
		List<T_SET_DETAIL> setDetail = clusterSetDetailDao.selectSetDetail(lastTime);
		List<T_SET_DETAIL> insertSetDetailList = new ArrayList<T_SET_DETAIL>();
		int i;
		for(i=0; i+ INSERT_COUNT<setDetail.size(); i+=INSERT_COUNT){
			insertSetDetailList = setDetail.subList(i,i+INSERT_COUNT);
			masterSetDetailDao.delete(insertSetDetailList);
			masterSetDetailDao.insert(insertSetDetailList);
		}
		insertSetDetailList = setDetail.subList(i,i+setDetail.size() % INSERT_COUNT);
		if(insertSetDetailList.size() > 0)
		{
			masterSetDetailDao.delete(insertSetDetailList);
			masterSetDetailDao.insert(insertSetDetailList);
		}
	}
	
	
	private void synCBMInfo(Timestamp lastTime) {
		List<T_CBM_INFO> cbmList = clusterCBMInfoDao.selectAllCBM(lastTime);
		if(cbmList!=null && cbmList.size()!=0) {
			List<T_CBM_INFO> list = new ArrayList<T_CBM_INFO>();
			int i;
			for (i = 0; i + INSERT_COUNT < cbmList.size(); i += INSERT_COUNT) {
				list = cbmList.subList(i, i + INSERT_COUNT);
				masterCBMInfoDao.delete(list);
				masterCBMInfoDao.insert(list);
			}
			list = cbmList.subList(i, i + cbmList.size() % INSERT_COUNT);
			if(list.size() > 0) {
				masterCBMInfoDao.delete(list);
				masterCBMInfoDao.insert(list);
			}
		}
	}

	@Override
	public void backUpBaggingAndMetalcheck(Map<String, Object> map) {
		procedureDao.backUpBaggingAndMetalcheck(map);
	}
}
