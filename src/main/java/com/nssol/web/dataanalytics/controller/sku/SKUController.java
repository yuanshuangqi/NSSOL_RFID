package com.nssol.web.dataanalytics.controller.sku;

import com.nssol.web.dataanalytics.service.sku.SKUOutput;
import com.nssol.web.dataanalytics.service.sku.SKUService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "SKU查询相关API")
@RequestMapping(value = "/api/sku")
public class SKUController {

    @Resource
    SKUService skuService;
    @PostMapping(value = "getSKUList")
    @ApiOperation(value = "SKU查询")
    public SKUResponse getSKUList(@RequestBody SKURequest skuRequest){
        SKUOutput skuOutput = skuService.getSKUList(skuRequest);
        SKUResponse skuResponse = new SKUResponse();
        BeanUtils.copyProperties(skuOutput,skuResponse);
        return skuResponse;
    }
}
