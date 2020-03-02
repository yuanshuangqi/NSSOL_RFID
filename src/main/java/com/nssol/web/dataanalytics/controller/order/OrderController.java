package com.nssol.web.dataanalytics.controller.order;

import com.nssol.web.dataanalytics.service.order.OrderOutput;
import com.nssol.web.dataanalytics.service.order.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = "订单查询相关接口")
@RequestMapping(value = "/api/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @ApiOperation(value = "订单查询")
    @PostMapping(value = "getList")
    public OrderResponse getOrderList(@RequestBody OrderRequest orderRequest){

    OrderResponse orderResponse = new OrderResponse();
    OrderOutput orderOutput = orderService.getOrderList(orderRequest);
        BeanUtils.copyProperties(orderOutput,orderResponse);
        return orderResponse;
    }

    @PostMapping(value = "downloadData")
    @ApiOperation(value = "导出订单信息")
    public void downloadBagging(@RequestBody OrderRequest orderRequest, HttpServletResponse response) {
        orderService.downloadOrder(orderRequest,response);
    }
}
