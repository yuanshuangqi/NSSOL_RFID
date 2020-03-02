package com.nssol.controller.bagging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TBaggingRequest;
import com.nssol.controller.response.TBaggingResponse;
import com.nssol.controller.response.TOrderDetailResponse;
import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Bagging;
import com.nssol.service.bagging.TBaggingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TBagging" })
public class TBaggingController {

	@Autowired
	private TBaggingService baggingService;

	@ApiOperation(value = "通过sku获取最新的po信息", notes = "查询数据库po信息", produces = "application/json")
    @RequestMapping(value = "/getOrderBySkuCode", method = RequestMethod.POST)
	public TOrderDetailResponse getOrderBySkuCode(@RequestBody TBaggingRequest bagRequest){
		T_Bagging bagInput = new T_Bagging();
		BeanUtils.copyProperties(bagRequest, bagInput);
		TOrderDetail orderDetailPut = baggingService.getOrderDetailBySkuCode(bagInput);
		
		TOrderDetailResponse retResponse = new TOrderDetailResponse();
		if(orderDetailPut!=null) {
			retResponse.setOrderDetail(orderDetailPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取当前页的包装信息", notes = "查询数据库包装信息", produces = "application/json")
    @RequestMapping(value = "/getBaggingListPage", method = RequestMethod.POST)
	public TBaggingResponse getBaggingListPage(@RequestBody TBaggingRequest bagRequest){
		T_Bagging bagInput = new T_Bagging();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<T_Bagging> baggingPut = baggingService.getBaggingListPage(bagInput);
		
		TBaggingResponse retResponse = new TBaggingResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setBaggingList(baggingPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取符合条件的所有的包装信息", notes = "查询数据库包装信息", produces = "application/json")
    @RequestMapping(value = "/getBaggingList", method = RequestMethod.POST)
	public TBaggingResponse getBaggingList(@RequestBody TBaggingRequest bagRequest){
		T_Bagging bagInput = new T_Bagging();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<T_Bagging> baggingPut = baggingService.getBaggingList(bagInput);
		
		TBaggingResponse retResponse = new TBaggingResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setBaggingList(baggingPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取当前包装台当天的信息", notes = "查询数据库包装信息", produces = "application/json")
    @RequestMapping(value = "/getBaggingByToday", method = RequestMethod.POST)
	public TBaggingResponse getBaggingByToday(@RequestBody TBaggingRequest bagRequest){
		T_Bagging bagInput = new T_Bagging();
		BeanUtils.copyProperties(bagRequest, bagInput);
		List<T_Bagging> baggingPut = baggingService.getBaggingByToday(bagInput);
		
		TBaggingResponse retResponse = new TBaggingResponse();
		if(baggingPut!=null && !baggingPut.isEmpty()) {
			retResponse.setBaggingList(baggingPut);
		}

		return retResponse;
	}
}
