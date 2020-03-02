package com.nssol.controller.tagging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TTaggingRequest;
import com.nssol.controller.response.TOrderDetailResponse;
import com.nssol.controller.response.TTaggingResponse;
import com.nssol.model.TOrderDetail;
import com.nssol.model.T_Tagging;
import com.nssol.service.tagging.TTaggingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = { "Operatioms about TTagging" })
public class TTaggingController {

	@Autowired
	private TTaggingService taggingService;

	@ApiOperation(value = "通过sku获取最新的po信息", notes = "查询数据库po信息", produces = "application/json")
    @RequestMapping(value = "/getOrderTaggingBySkuCode", method = RequestMethod.POST)
	public TOrderDetailResponse getOrderTaggingBySkuCode(@RequestBody TTaggingRequest tagRequest){
		T_Tagging tagInput = new T_Tagging();
		BeanUtils.copyProperties(tagRequest, tagInput);
		TOrderDetail orderDetailPut = taggingService.getOrderDetailBySkuCode(tagInput);
		
		TOrderDetailResponse retResponse = new TOrderDetailResponse();
		if(orderDetailPut!=null) {
			retResponse.setOrderDetail(orderDetailPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取当前页的包装信息", notes = "查询数据库包装信息", produces = "application/json")
    @RequestMapping(value = "/getTaggingListPage", method = RequestMethod.POST)
	public TTaggingResponse getTaggingListPage(@RequestBody TTaggingRequest tagRequest){
		T_Tagging tagInput = new T_Tagging();
		BeanUtils.copyProperties(tagRequest, tagInput);
		List<T_Tagging> taggingPut = taggingService.getTaggingListPage(tagInput);
		
		TTaggingResponse retResponse = new TTaggingResponse();
		if(taggingPut!=null && !taggingPut.isEmpty()) {
			retResponse.setTaggingList(taggingPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取符合条件的所有的包装信息", notes = "查询数据库包装信息", produces = "application/json")
    @RequestMapping(value = "/getTaggingList", method = RequestMethod.POST)
	public TTaggingResponse getTaggingList(@RequestBody TTaggingRequest tagRequest){
		T_Tagging tagInput = new T_Tagging();
		BeanUtils.copyProperties(tagRequest, tagInput);
		List<T_Tagging> taggingPut = taggingService.getTaggingList(tagInput);
		
		TTaggingResponse retResponse = new TTaggingResponse();
		if(taggingPut!=null && !taggingPut.isEmpty()) {
			retResponse.setTaggingList(taggingPut);
		}

		return retResponse;
	}
	
	@ApiOperation(value = "通过查询条件获取当前包装台当天的信息", notes = "查询数据库包装信息", produces = "application/json")
    @RequestMapping(value = "/getTaggingByToday", method = RequestMethod.POST)
	public TTaggingResponse getTaggingByToday(@RequestBody TTaggingRequest tagRequest){
		T_Tagging tagInput = new T_Tagging();
		BeanUtils.copyProperties(tagRequest, tagInput);
		List<T_Tagging> taggingPut = taggingService.getTaggingByToday(tagInput);
		
		TTaggingResponse retResponse = new TTaggingResponse();
		if(taggingPut!=null && !taggingPut.isEmpty()) {
			retResponse.setTaggingList(taggingPut);
		}

		return retResponse;
	}
}
