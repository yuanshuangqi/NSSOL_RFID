package com.nssol.controller.bagging;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TOrderDetailRequest;
import com.nssol.controller.response.TOrderDetailListResponse;
import com.nssol.controller.response.TOrderDetailResponse;
import com.nssol.model.TOrderDetail;
import com.nssol.service.bagging.TOrderDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about OrderDetail" })
public class TOrderDetailController {

	@Autowired
	private TOrderDetailService orderDetailService;
	
	@ApiOperation(value = "通过sku获取最新的po信息", notes = "查询数据库po信息", produces = "application/json")
    @RequestMapping(value = "/getOrderDetailListBysku", method = RequestMethod.POST)
	public TOrderDetailListResponse getOrderDetailListBysku(@RequestBody TOrderDetailRequest orderDetail){
		TOrderDetail input = new TOrderDetail();
		BeanUtils.copyProperties(orderDetail, input);
		List<TOrderDetail> orderDetailPut = orderDetailService.getOrderDetailListBysku(input);
		
		TOrderDetailListResponse retResponse = new TOrderDetailListResponse();
		if(orderDetailPut!=null && ! orderDetailPut.isEmpty()) {
			retResponse.setOrderDetailList(orderDetailPut);
			}
		return retResponse;
	}
	
	@ApiOperation(value = "通过po获取最新的skucode", notes = "查询数据库skucode信息", produces = "application/json")
    @RequestMapping(value = "/getSkuListByOrderNo", method = RequestMethod.POST)
	public TOrderDetailListResponse getSkuListByOrderNo(@RequestBody TOrderDetailRequest orderDetail){
		TOrderDetail input = new TOrderDetail();
		BeanUtils.copyProperties(orderDetail, input);
		List<TOrderDetail> orderDetailPut = orderDetailService.getSkuListByOrderNo(input);
		
		TOrderDetailListResponse retResponse = new TOrderDetailListResponse();
		if(orderDetailPut!=null && ! orderDetailPut.isEmpty()) {
			retResponse.setOrderDetailList(orderDetailPut);
			}
		return retResponse;
	}
	
	@ApiOperation(value = "通过sku, PO获取最新的po信息", notes = "查询数据库SKU信息", produces = "application/json")
    @RequestMapping(value = "/getOrderDetailListByPoSku", method = RequestMethod.POST)
	public TOrderDetailResponse getOrderDetailListByPoSku(@RequestBody TOrderDetailRequest orderDetail){
		TOrderDetail input = new TOrderDetail();
		BeanUtils.copyProperties(orderDetail, input);
		TOrderDetail orderDetailPut = orderDetailService.getOrderDetailListByPoSku(input);
		
		TOrderDetailResponse retResponse = new TOrderDetailResponse();
		retResponse.setOrderDetail(orderDetailPut);
		return retResponse;
	}
	
}