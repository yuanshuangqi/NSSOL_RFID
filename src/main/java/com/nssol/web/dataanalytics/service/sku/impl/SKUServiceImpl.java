package com.nssol.web.dataanalytics.service.sku.impl;

import com.nssol.dao.master.SKUDao;
import com.nssol.web.dataanalytics.controller.sku.SKURequest;
import com.nssol.web.dataanalytics.model.SKUInfo;
import com.nssol.web.dataanalytics.service.sku.SKUOutput;
import com.nssol.web.dataanalytics.service.sku.SKUService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SKUServiceImpl implements SKUService {
    @Resource
    SKUDao skuDao;
    @Override
    public SKUOutput getSKUList(SKURequest skuRequest) {
        SKUOutput skuOutput = new SKUOutput();
        if(StringUtils.isEmpty(skuRequest.getSkuCode()) && StringUtils.isEmpty(skuRequest.getSizeCode()) && StringUtils.isEmpty(skuRequest.getColorCode())){
            skuRequest.setPageStart(0);
            skuRequest.setPageEnd(21);
        }else {
            skuRequest.setPageStart(0);
            skuRequest.setPageEnd(41);
        }
        List<SKUInfo> skuInfoList = new ArrayList<SKUInfo>();
        if("Tagging".equals(skuRequest.getDicType())){
            skuInfoList = skuDao.getSKUTagging(skuRequest);
        }
        if("Bagging".equals(skuRequest.getDicType())){
             skuInfoList = skuDao.getSKUBagging(skuRequest);
        }
        if("MetalCheck".equals(skuRequest.getDicType())){
             skuInfoList = skuDao.getSKUMetalCheck(skuRequest);
        }
        List<SKUInfo> skuDataList = new ArrayList<SKUInfo>();
        for (SKUInfo skuInfo:skuInfoList){
                skuInfo.setRedQty(skuInfo.getOrderQty()-skuInfo.getScanNum());
                skuInfo.setBlueQty(skuInfo.getScanNum());
                skuDataList.add(skuInfo);
        }
        skuOutput.setSkuInfoData(skuDataList);
        return skuOutput;
    }
}
