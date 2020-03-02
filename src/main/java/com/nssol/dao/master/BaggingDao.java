package com.nssol.dao.master;

import com.nssol.web.dataanalytics.controller.bagging.BaggingRequest;
import com.nssol.web.dataanalytics.model.BaggingInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BaggingDao {
    /**
     * 获取包装总数
     * @param baggingRequest
     * @return
     */
    Long getBaggingTotalCount(BaggingRequest baggingRequest);

    /**
     * 获取packingInfoList
     * @param packingRequest
     * @return
     */
    List<BaggingInfo> getBaggingList(BaggingRequest packingRequest);
}
