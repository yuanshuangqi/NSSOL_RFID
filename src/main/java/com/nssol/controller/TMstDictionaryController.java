package com.nssol.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TMstDictionaryRequest;
import com.nssol.controller.response.TMstDictionaryResponse;
import com.nssol.model.TMetalcheck;
import com.nssol.model.TMstDictionary;
import com.nssol.service.TMstDictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TMstDictionary" })
public class TMstDictionaryController {

	@Autowired
	private TMstDictionaryService dictService;
	
	@ApiOperation(value = "获取所有的设备地址信息", notes = "查询数据库字典信息", produces = "application/json")
    @RequestMapping(value = "/getMstDictionaryList", method = RequestMethod.POST)
	public TMstDictionaryResponse getMstDictionaryList(@RequestBody TMstDictionaryRequest mstDictionaryRequest){
		
		TMstDictionary mstDict = new TMstDictionary();
		BeanUtils.copyProperties(mstDictionaryRequest, mstDict);
		
		List<TMstDictionary> dicList = dictService.getMstDictionary(mstDict);
		
		TMstDictionaryResponse retResponse = new TMstDictionaryResponse();
		if(dicList!=null && !dicList.isEmpty()) {
			retResponse.setDictionaryList(dicList);
		}
		return retResponse;
	}

	@ApiOperation(value = "获取未被使用的设备地址信息", notes = "获取未被使用的设备地址信息", produces = "application/json")
	@RequestMapping(value = "/getEnableAddress", method = RequestMethod.POST)
	public TMstDictionaryResponse getEnableAddress(@RequestBody TMstDictionaryRequest mstDictionaryRequest){

		TMstDictionary mstDict = new TMstDictionary();
		BeanUtils.copyProperties(mstDictionaryRequest, mstDict);

		List<TMstDictionary> dicList = dictService.getEnableAddress(mstDict);

		TMstDictionaryResponse retResponse = new TMstDictionaryResponse();
		if(dicList!=null && !dicList.isEmpty()) {
			retResponse.setDictionaryList(dicList);
		}
		return retResponse;
	}

	@ApiOperation(value = "设置设备地址信息", notes = "查询数据库字典信息", produces = "application/json")
	@RequestMapping(value = "/setMstDictionaryList", method = RequestMethod.POST)
	public void setMstDictionaryList(@RequestBody TMstDictionaryRequest mstDictionaryRequest){

		TMstDictionary mstDict = new TMstDictionary();
		BeanUtils.copyProperties(mstDictionaryRequest, mstDict);
		dictService.clearAddress(mstDict);
		if(mstDict.getId()!=null && mstDict.getId()!="")
		dictService.setMstDictionary(mstDict);
	}
	
}