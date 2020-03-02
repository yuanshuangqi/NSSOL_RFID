package com.nssol.dao.master;

import com.nssol.web.dataanalytics.controller.bagging.BaggingRequest;
import com.nssol.web.dataanalytics.controller.metalcheck.MetalCheckRequest;
import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.web.dataanalytics.model.MetalCheckInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MetalCheckDao {
    /**
     * 获取检针总数
     * @param metalCheckRequest
     * @return
     */
    Long getMetalCheckTotalCount(MetalCheckRequest metalCheckRequest);

    /**
     * MetalCheckList
     * @param metalCheckRequest
     * @return
     */
    List<MetalCheckInfo> getMetalCheckList(MetalCheckRequest metalCheckRequest);
}
