package com.nssol.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TBasicInfoRequest;
import com.nssol.controller.response.TBasicInfoResponse;
import com.nssol.model.TBasicInfo;
import com.nssol.service.TBasicInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TBasicInfo" })
public class TBasicInfoController {

	@Autowired
	private TBasicInfoService basicInfoService;
	
	@ApiOperation(value = "获取基础信息", notes = "查询数据库T_Basic_Info信息", produces = "application/json")
	
    @RequestMapping(value = "/getBasicInfo", method = RequestMethod.POST)
	public TBasicInfoResponse getBasicInfo(@RequestBody TBasicInfoRequest basicRequest){
		
		TBasicInfo mstDict = new TBasicInfo();
		BeanUtils.copyProperties(basicRequest, mstDict);
		
		 List<TBasicInfo> basicInfoList = basicInfoService.getBasicInfo(mstDict);
		
		TBasicInfoResponse retResponse = new TBasicInfoResponse();
		if(basicInfoList!=null && !basicInfoList.isEmpty()) {
			retResponse.setBasicInfoList(basicInfoList);
		}
		return retResponse;
	}
	
}