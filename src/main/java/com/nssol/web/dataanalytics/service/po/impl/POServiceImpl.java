package com.nssol.web.dataanalytics.service.po.impl;

import com.nssol.dao.master.PODao;
import com.nssol.web.dataanalytics.controller.po.PORequest;
import com.nssol.web.dataanalytics.model.POInfo;
import com.nssol.web.dataanalytics.model.RuleInfo;
import com.nssol.web.dataanalytics.service.po.POOutput;
import com.nssol.web.dataanalytics.service.po.POService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class POServiceImpl implements POService{
    @Resource
    PODao poDao;
    @Override
    public POOutput getPOList(PORequest poRequest) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        RuleInfo ruleInfo = poDao.getRuleInfo(1);
        Calendar c = Calendar.getInstance();
        //当前时间
        Date sysDate = new Date();
        String nowDate = format.format(sysDate);
        //未来LessETD1天
        c.setTime(new Date());
        c.add(Calendar.DATE, + (ObjectUtils.isEmpty(ruleInfo.getLessETD1())?0:ruleInfo.getLessETD1()));
        Date d = c.getTime();
        String lessETD1 = format.format(d);
        //未来LessETD2天
        c.setTime(new Date());
        c.add(Calendar.DATE, +(ObjectUtils.isEmpty(ruleInfo.getLessETD2())?0:ruleInfo.getLessETD2()));
        Date m = c.getTime();
        String lessETD2 = format.format(m);
        POOutput poOutput = new POOutput();
        List<POInfo> poInfoList = new ArrayList<POInfo>();
        poOutput.setLessETD1(ObjectUtils.isEmpty(ruleInfo.getLessETD1())?0:ruleInfo.getLessETD1());
        poOutput.setLessETD2(ObjectUtils.isEmpty(ruleInfo.getLessETD2())?0:ruleInfo.getLessETD2());
        poRequest.setDateFrom(getDate(poRequest.getDateFrom()));
        poRequest.setDateTo(getDate(poRequest.getDateTo()));
        if("Tagging".equals(poRequest.getDicType())){
            poInfoList = poDao.getPOTagging(poRequest);
        }
        if("Bagging".equals(poRequest.getDicType())){
             poInfoList = poDao.getPOBagging(poRequest);
        }
        if("MetalCheck".equals(poRequest.getDicType())){
             poInfoList = poDao.getPOMetalCheck(poRequest);
        }
        List<POInfo> poDataList = new ArrayList<POInfo>();
        for (POInfo poInfo:poInfoList){
            int nowFlag = poInfo.getETD().compareTo(nowDate);
            int etd1Flag = poInfo.getETD().compareTo(lessETD1);
            int etd2Flag = poInfo.getETD().compareTo(lessETD2);
            double percentQty = ObjectUtils.isEmpty(ruleInfo.getPercentQty())?0:ruleInfo.getPercentQty()/100;
            if(nowFlag <= 0){
                poInfo.setRedQty(poInfo.getOrderQty()-poInfo.getScanNum());
            }else if(etd1Flag <= 0){
                poInfo.setOrangeQty(poInfo.getOrderQty()-poInfo.getScanNum());
            }else if(etd2Flag <= 0 && poInfo.getScanNum()< poInfo.getOrderQty()*percentQty){
                poInfo.setYellowQty(poInfo.getOrderQty()-poInfo.getScanNum());
            }
            if(etd2Flag <= 0 && poInfo.getScanNum() >= poInfo.getOrderQty()*percentQty){
                poInfo.setBlueQty(poInfo.getOrderQty());
            }else {
                poInfo.setBlueQty(poInfo.getScanNum());
            }
            poDataList.add(poInfo);
        }
        poOutput.setPoInfoData(poDataList);
        return poOutput;
    }

    private String getDate(String date){
        if(!StringUtils.isEmpty(date)) {
            String[] strArr = date.split("T");
            return strArr[0];
        }
        return null;
    }
}
