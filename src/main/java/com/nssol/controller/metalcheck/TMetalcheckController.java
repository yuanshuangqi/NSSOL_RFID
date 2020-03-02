package com.nssol.controller.metalcheck;

import java.util.ArrayList;
import java.util.List;

import com.nssol.controller.request.TSensitivityRequest;
import com.nssol.controller.response.TSensitivityResponse;
import com.nssol.model.TMetalcheckSensitivity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.FallbackWebSecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TBaggingRequest;
import com.nssol.controller.request.TMetalcheckRequest;
import com.nssol.controller.response.TMetalcheckResponse;
import com.nssol.controller.response.TOrderDetailResponse;
import com.nssol.model.TMetalcheck;
import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Bagging;
import com.nssol.service.metalcheck.TMetalcheckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TMetalcheck" })
public class TMetalcheckController {

	@Autowired
	private TMetalcheckService metalCheckService;

	@ApiOperation(value = "通过sku获取最新的po信息", notes = "查询数据库po信息", produces = "application/json")
    @RequestMapping(value = "/getOrderAutoBySkuCode", method = RequestMethod.POST)
	public TOrderDetailResponse getOrderAutoBySkuCode(@RequestBody TMetalcheckRequest metalcheckRequest){

		TMetalcheck metalcheckInput = new TMetalcheck();
		BeanUtils.copyProperties(metalcheckRequest, metalcheckInput);
		TOrderDetail orderDetailPut = metalCheckService.getOrderDetailAutoBySkuCode(metalcheckInput);

		TOrderDetailResponse retResponse = new TOrderDetailResponse();
		if(orderDetailPut!=null) {
			retResponse.setOrderDetail(orderDetailPut);
		}
		return retResponse;
	}
	
	@ApiOperation(value = "保存检针信息", notes = "保存检针信息", produces = "application/json")
    @RequestMapping(value = "/getSaveMetalCheckList", method = RequestMethod.POST)
	public TMetalcheckResponse getSaveMetalCheckList(@RequestBody List<TMetalcheckRequest> metalcheckRequestList){
		List<TMetalcheck> metalInput = new ArrayList<TMetalcheck>();
		for(TMetalcheckRequest teamMetal:metalcheckRequestList) {
			TMetalcheck metalcheck = new TMetalcheck();
			metalcheck.setOrderNo(teamMetal.getOrderNo());
			metalcheck.setDetailNo(teamMetal.getDetailNo());
			metalcheck.setSkuCode(teamMetal.getSkuCode());
			metalcheck.setBaggingAddress(teamMetal.getBaggingAddress());
			metalcheck.setCreateTime(teamMetal.getCreateTime());
			metalcheck.setEpc(teamMetal.getEpc());
			metalInput.add(metalcheck);
		}

		metalCheckService.getSaveMetalCheckList(metalInput);
		
		TMetalcheckResponse retResponse = new TMetalcheckResponse();
		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取当前页的检针信息", notes = "查询数据库检针信息", produces = "application/json")
    @RequestMapping(value = "/getMetalcheckListPage", method = RequestMethod.POST)
	public TMetalcheckResponse getMetalcheckListPage(@RequestBody TMetalcheckRequest bagRequest){
		TMetalcheck bagInput = new TMetalcheck();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<TMetalcheck> baggingPut = metalCheckService.getMetalcheckPage(bagInput);
		
		TMetalcheckResponse retResponse = new TMetalcheckResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setMetalcheckList(baggingPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取符合条件的所有的检针信息", notes = "查询数据库检针信息", produces = "application/json")
    @RequestMapping(value = "/getMetalcheckList", method = RequestMethod.POST)
	public TMetalcheckResponse getMetalcheckList(@RequestBody TMetalcheckRequest bagRequest){
		TMetalcheck bagInput = new TMetalcheck();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<TMetalcheck> baggingPut = metalCheckService.getMetalcheckList(bagInput);
		
		TMetalcheckResponse retResponse = new TMetalcheckResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setMetalcheckList(baggingPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取当前检针台当天的信息", notes = "查询数据库检针信息", produces = "application/json")
    @RequestMapping(value = "/getMetalcheckByToday", method = RequestMethod.POST)
	public TMetalcheckResponse getMetalcheckByToday(@RequestBody TMetalcheckRequest bagRequest){
		TMetalcheck bagInput = new TMetalcheck();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<TMetalcheck> baggingPut = metalCheckService.getMetalcheckByToday(bagInput);
		
		TMetalcheckResponse retResponse = new TMetalcheckResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setMetalcheckList(baggingPut);
		}

		return retResponse;
	}

	@ApiOperation(value = "通过查询条件获取符合条件的所有的检针标准信息", notes = "查询数据库检针标准信息", produces = "application/json")
	@RequestMapping(value = "/getSensitivityList", method = RequestMethod.POST)
	public TSensitivityResponse getSensitivityList(@RequestBody TSensitivityRequest bagRequest){
		TMetalcheck bagInput = new TMetalcheck();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<TMetalcheckSensitivity> baggingPut = metalCheckService.getSensitivityList(bagInput);

		TSensitivityResponse retResponse = new TSensitivityResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setMetalcheckSensitivityList(baggingPut);
		}

		return retResponse;
	}

	@ApiOperation(value = "清空所有检针信息", notes = "清空所有检针信息", produces = "application/json")
	@RequestMapping(value = "/deleteMetalcheckData", method = RequestMethod.POST)
	public void deleteMetalcheckData(@RequestBody String msg){
		metalCheckService.deleteMetalcheckData();
	}
}
