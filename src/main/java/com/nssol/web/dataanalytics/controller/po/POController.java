package com.nssol.web.dataanalytics.controller.po;

import com.nssol.web.dataanalytics.service.po.POOutput;
import com.nssol.web.dataanalytics.service.po.POService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "PO查询相关API")
@RequestMapping(value = "/api/po")
public class POController {

    @Resource
    POService poService;
    @PostMapping(value = "getPOList")
    @ApiOperation(value = "PO查询")
    public POResponse getPOList(@RequestBody PORequest poRequest){
        POOutput poOutput = poService.getPOList(poRequest);
        POResponse poResponse = new POResponse();
        BeanUtils.copyProperties(poOutput,poResponse);
        return poResponse;
    }
}
