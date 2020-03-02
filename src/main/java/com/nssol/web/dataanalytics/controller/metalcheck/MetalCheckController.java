package com.nssol.web.dataanalytics.controller.metalcheck;

import com.nssol.web.dataanalytics.service.metalcheck.MetalCheckOutput;
import com.nssol.web.dataanalytics.service.metalcheck.MetalCheckService;
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
@Api("检针查询相关API")
@RequestMapping(value = "/api/metalcheck")
public class MetalCheckController {
    @Resource
    MetalCheckService metalCheckService;
    @PostMapping(value = "/getList")
    @ApiOperation(value = "检针查询")
    public MetalCheckResponse getMetalCheckList(@RequestBody MetalCheckRequest metalCheckRequest){
        MetalCheckResponse metalCheckResponse = new MetalCheckResponse();
        MetalCheckOutput metalCheckOutput = metalCheckService.getMetalCheckList(metalCheckRequest);
        BeanUtils.copyProperties(metalCheckOutput,metalCheckResponse);
        return metalCheckResponse;
    }

    @PostMapping(value = "downloadData")
    @ApiOperation(value = "导出检针信息")
    public void downloadBagging(@RequestBody MetalCheckRequest metalCheckRequest, HttpServletResponse response) {
        metalCheckService.downloadMetalCheck(metalCheckRequest,response);
    }
}
