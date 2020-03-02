package com.nssol.dao.master;

import com.nssol.web.dataanalytics.model.ProductionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DataManagementDao {
    /*get dataanalytics Tagging totaldata*/
    Integer getTaggingTotal(@Param("dateFrom") String dateFrom, @Param("dateTo")String dateTo);
    /*get dataanalytics bagging totaldata*/
    Integer getBaggingTotal(@Param("dateFrom") String dateFrom, @Param("dateTo")String dateTo);
    /*get dataanalytics MetalCheck totaldata*/
    Integer getMetalCheckTotal(@Param("dateFrom") String dateFrom, @Param("dateTo")String dateTo);
    /* get 每台设备产量*/
    List<ProductionInfo> getProduction(@Param("dateFrom") String dateFrom, @Param("dateTo")String dateTo);
}
