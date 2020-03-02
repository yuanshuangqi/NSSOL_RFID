package com.nssol.task;

import java.util.HashMap;
import java.util.Map;

import com.nssol.service.report.MetalcheckReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.nssol.service.po_import.PoImportService;



@Component
public class BatchTask {

	@Autowired
	private PoImportService poImportService;
	@Autowired
	private MetalcheckReportService metalcheckReportService;
	
	/**
	 * 每天0，6,12,18点运行一次 更新PO等信息
	 */
	//@Scheduled(cron="0 0 0,6,12,18 * * ? ")
	public void poImport(){
		poImportService.synBatch();
	}

	/**
	 * 每天0:10点运行一次 更新报表数据源
	 */
	//@Scheduled(cron="0 30 0 * * ? ")
	public void refreshTableau(){
		metalcheckReportService.synBatch(null,null);
	}
	/**
	 * 每周日00:05分运行一次 备份检针信息
	 */
	//@Scheduled(cron="0 5 0 ? * SUN ")
	public void backUpBaggingAndMetalcheck() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorMsg", null);
		poImportService.backUpBaggingAndMetalcheck(map);
		if(!StringUtils.isEmpty(map.get("errorMsg"))) {
			throw new Exception((String)map.get("errorMsg"));
		}
	}

}
