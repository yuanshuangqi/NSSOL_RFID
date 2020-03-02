package com.nssol.web.dataanalytics.controller.bagging;

import com.nssol.web.dataanalytics.service.bagging.BaggingService;
import com.nssol.web.dataanalytics.service.bagging.BaggingOutput;
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
@Api(tags = "包装查询相关API")
@RequestMapping(value = "/api/bagging")
public class BaggingController {

    @Resource
    BaggingService baggingService;
    @PostMapping(value = "getList")
    @ApiOperation(value = "包装查询")
    public BaggingResponse getPackingList(@RequestBody BaggingRequest baggingRequest){
        BaggingResponse response = new BaggingResponse();
        BaggingOutput output = baggingService.getBaggingList(baggingRequest);
        BeanUtils.copyProperties(output,response);
        return response;
    }
    @PostMapping(value = "downloadData")
    @ApiOperation(value = "导出包装信息")
    public void downloadBagging(@RequestBody BaggingRequest baggingRequest, HttpServletResponse response) {
        baggingService.downloadBagging(baggingRequest,response);
    }

}
