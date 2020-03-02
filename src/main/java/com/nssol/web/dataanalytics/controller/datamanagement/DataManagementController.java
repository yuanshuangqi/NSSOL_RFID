package com.nssol.web.dataanalytics.controller.datamanagement;

import com.nssol.web.dataanalytics.service.datamanagement.DataManagementService;
import com.nssol.web.dataanalytics.service.datamanagement.RfidDataOutput;
import com.nssol.web.dataanalytics.service.datamanagement.ProductionOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = "数据管理相关API")
@RequestMapping(value = "/api/dataanalytics")
public class DataManagementController {
    @Resource
    DataManagementService dataManagementService;
    @PostMapping(value = "/data")
    @ApiOperation(value = "根据日期RFID数据")
    public RfidDataResponse getFridData(@RequestBody ProductionRequest productionRequest){
        RfidDataResponse rfidDataResponse = new RfidDataResponse();
        RfidDataOutput rfidDataOutput = dataManagementService.getRfidData(productionRequest);
        if(!ObjectUtils.isEmpty(rfidDataOutput)){
            BeanUtils.copyProperties(rfidDataOutput,rfidDataResponse);
        }
        return rfidDataResponse;
    }

    @PostMapping(value = "/production")
    @ApiOperation(value = "根据日期查询设备产量")
    public ProductionResponse getProduction(@RequestBody ProductionRequest productionRequest){
        ProductionResponse productionResponse = new ProductionResponse();
        ProductionOutput productionOutput = dataManagementService.getProduction(productionRequest);
        if(!ObjectUtils.isEmpty(productionOutput)){
            BeanUtils.copyProperties(productionOutput,productionResponse);
        }
        return productionResponse;
    }
}
