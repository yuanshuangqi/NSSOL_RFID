package com.nssol.service.report.impl;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.common.Constant;
import com.nssol.dao.master.MasterBatchProcessDao;
import com.nssol.dao.master.ReportDao;
import com.nssol.model.T_BATCH_PROCESS;
import com.nssol.service.report.MetalcheckReportService;


@Service
@Transactional
public class MetalcheckReportServiceImpl implements MetalcheckReportService,Constant {


	@Autowired
	private MasterBatchProcessDao masterBatchProcessDao;
	
	@Autowired
	private ReportDao reportDao;
	

	@Override
	public void synBatch(Timestamp startTime,Timestamp endTime){
		T_BATCH_PROCESS batchProcess = masterBatchProcessDao.getLastTime(Metalcheck_Report);
		if(batchProcess==null){
			batchProcess = new T_BATCH_PROCESS(Metalcheck_Report);
			batchProcess.setProcess_time(Timestamp.valueOf("1900-01-01 00:00:00"));
		}
		if(batchProcess.getProcess_flag()==0){
			try{
				T_BATCH_PROCESS newBatchProcess = new T_BATCH_PROCESS(Metalcheck_Report);
				batchProcess.setProcess_flag(1);
				masterBatchProcessDao.updateProcessFlag(batchProcess);
				if(startTime == null){
					startTime = batchProcess.getProcess_time();
				}
				if(endTime == null){
					endTime = new Timestamp(System.currentTimeMillis());
				}
				reportDao.delete(startTime,endTime);
				reportDao.insert(startTime,endTime);
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

}
