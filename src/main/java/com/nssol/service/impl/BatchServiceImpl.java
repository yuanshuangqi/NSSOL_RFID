package com.nssol.service.impl;

import com.nssol.dao.master.TBasicInfoDao;
import com.nssol.model.TBasicInfo;
import com.nssol.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {
    @Autowired
    private TBasicInfoDao tBasicInfoDao;

    @Override
    public String getBasicInfo(String batchName){
        TBasicInfo tBasicInfo = new TBasicInfo();
        tBasicInfo.setType(batchName);
        TBasicInfo basicInfo = tBasicInfoDao.getBasicInfo(tBasicInfo);
        if(basicInfo==null){
            return null;
        }
        return basicInfo.getValue();
    }

    @Override
    public void setBasicInfo(String batchName,String batchCron){
        TBasicInfo tBasicInfo = new TBasicInfo();
        tBasicInfo.setType(batchName);
        tBasicInfo.setValue(batchCron);
        tBasicInfoDao.setBasicInfo(tBasicInfo);
    }
}
