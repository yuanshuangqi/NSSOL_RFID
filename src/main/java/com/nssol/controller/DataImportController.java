package com.nssol.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.nssol.service.report.MetalcheckReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.response.DataImportResponse;
import com.nssol.service.po_import.PoImportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about Data Import" })
public class DataImportController {
	
	@Autowired
	private PoImportService poImportService;

	@Autowired
	private MetalcheckReportService metalcheckReportService;

	@ApiOperation(value = "PO数据同步", notes = "数据同步", produces = "application/json")
    @RequestMapping(value = "/poImport", method = RequestMethod.GET)
	public DataImportResponse poImport(){
		poImportService.synBatch();
		DataImportResponse dataImportResponse = new DataImportResponse();
		dataImportResponse.setMessage("success");
		return dataImportResponse;
	}

	@ApiOperation(value = "展示表数据同步", notes = "展示数据同步", produces = "application/json")
	@RequestMapping(value = "/reportImport", method = RequestMethod.POST)
	public DataImportResponse ReportImport(@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime){
		metalcheckReportService.synBatch(Timestamp.valueOf(startTime),Timestamp.valueOf(endTime));
		DataImportResponse dataImportResponse = new DataImportResponse();
		dataImportResponse.setMessage("success");
		return dataImportResponse;
	}

	@ApiOperation(value = "包装及检针RFID数据备份", notes = "数据备份", produces = "application/json")
    @RequestMapping(value = "/backUpBaggingAndMetalcheck", method = RequestMethod.GET)
	public DataImportResponse backUpBaggingAndMetalcheck() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorMsg", null);
		poImportService.backUpBaggingAndMetalcheck(map);
		DataImportResponse dataImportResponse = new DataImportResponse();
		if(!StringUtils.isEmpty(map.get("errorMsg"))) {
			dataImportResponse.setMessage((String)map.get("errorMsg"));
		} else {
			dataImportResponse.setMessage("success");
		}
		return dataImportResponse;
		
	}
}
