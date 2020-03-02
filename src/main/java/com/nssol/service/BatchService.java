package com.nssol.service;


public interface BatchService {
    public String getBasicInfo(String batchName);

    public void setBasicInfo(String batchName,String batchCron);
}
