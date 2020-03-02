package com.nssol.web.dataanalytics.service.datamanagement.impl;


import com.nssol.dao.master.DataManagementDao;
import com.nssol.web.common.constants.RfidConstants;
import com.nssol.web.dataanalytics.controller.datamanagement.ProductionRequest;
import com.nssol.web.dataanalytics.model.ProductionInfo;
import com.nssol.web.dataanalytics.model.RfidDataInfo;
import com.nssol.web.dataanalytics.service.datamanagement.DataManagementService;
import com.nssol.web.dataanalytics.service.datamanagement.ProductionOutput;
import com.nssol.web.dataanalytics.service.datamanagement.RfidDataOutput;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataManagementServiceImpl implements DataManagementService {
    @Resource
    DataManagementDao dataManagementDao;
    @Override
    public RfidDataOutput getRfidData(ProductionRequest productionRequest) {
        String dateFrom = getDate(productionRequest.getDateFrom());
        String dateTo = getDate(productionRequest.getDateTo());
        List<RfidDataInfo> fridDataList =  new ArrayList<RfidDataInfo>();
        RfidDataInfo taggingInfo = new RfidDataInfo();
        taggingInfo.setProcessName(RfidConstants.TAGGING_NAME);
        Integer taggingTotal = 0;
        if(StringUtils.isEmpty(productionRequest.getDicType())|| editConditionToList(productionRequest.getDicType(),RfidConstants.SIGN_COMMA).contains("Tagging")) {
             taggingTotal = dataManagementDao.getTaggingTotal(dateFrom, dateTo);
        }
        taggingInfo.setTotalCount(StringUtils.isEmpty(taggingTotal)?0:taggingTotal);
        fridDataList.add(taggingInfo);
        RfidDataInfo baggingInfo = new RfidDataInfo();
        baggingInfo.setProcessName(RfidConstants.BAGGING_NAME);
        Integer baggingTotal = 0;
        if(StringUtils.isEmpty(productionRequest.getDicType())|| editConditionToList(productionRequest.getDicType(),RfidConstants.SIGN_COMMA).contains("Bagging")) {
             baggingTotal = dataManagementDao.getBaggingTotal(dateFrom, dateTo);
        }
        baggingInfo.setTotalCount(StringUtils.isEmpty(baggingTotal)?0:baggingTotal);
        fridDataList.add(baggingInfo);
        RfidDataInfo metalCheckTotal = new RfidDataInfo();
        metalCheckTotal.setProcessName(RfidConstants.METALCHECK_NAME);
        Integer checkTotal = 0;
        if(StringUtils.isEmpty(productionRequest.getDicType())|| editConditionToList(productionRequest.getDicType(),RfidConstants.SIGN_COMMA).contains("MetalCheck")) {
             checkTotal = dataManagementDao.getMetalCheckTotal(dateFrom, dateTo);
        }
        metalCheckTotal.setTotalCount(StringUtils.isEmpty(checkTotal)?0:checkTotal);
        fridDataList.add(metalCheckTotal);
        RfidDataOutput fridDataOutput = new RfidDataOutput();
        fridDataOutput.setRfidDataInfoList(fridDataList);
        return fridDataOutput;
    }
    /**get设备产量*/
    public ProductionOutput getProduction(ProductionRequest productionRequest){
        String dateFrom = getDate(productionRequest.getDateFrom());
        String dateTo = getDate(productionRequest.getDateTo());
        List<ProductionInfo> productionInfos = dataManagementDao.getProduction(dateFrom,dateTo);
        ProductionOutput productionOutput = new ProductionOutput();
        if(!StringUtils.isEmpty(productionRequest.getDicType())){
            List<ProductionInfo> productionInfoList = new ArrayList<ProductionInfo>();
            for(ProductionInfo productionInfo:productionInfos){
                if(editConditionToList(productionRequest.getDicType(),RfidConstants.SIGN_COMMA).contains(productionInfo.getDicType())){
                    productionInfoList.add(productionInfo);
                }
            }
            productionOutput.setProductionInfoList(productionInfoList);
        }else {
        productionOutput.setProductionInfoList(productionInfos);
        }
        return productionOutput;
    }
    private String getDate(String date){
        String[] strArr = date.split("T");
        return strArr[0];
    }

    /**
     * split the string with a comma and edit it into list
     *
     * @param selectCondition String
     * @param splitKey        String
     *
     */
    private List<String> editConditionToList(String selectCondition, String splitKey) {
        List<String> conditionList = new ArrayList<>();
        if (!StringUtils.isEmpty(selectCondition)) {
            String[] conditionArray = selectCondition.split(splitKey);

            for (String condition : conditionArray) {
                conditionList.add(condition);
            }
        }
        return conditionList;
    }

}
