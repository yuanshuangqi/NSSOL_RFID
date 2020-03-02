package com.nssol.dao.master;

import com.nssol.web.dataanalytics.controller.bagging.BaggingRequest;
import com.nssol.web.dataanalytics.controller.po.PORequest;
import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.web.dataanalytics.model.POInfo;
import com.nssol.web.dataanalytics.model.RuleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PODao {
    /**
     * 获取包装信息
     * @param poRequest
     * @return
     */
    List<POInfo> getPOBagging(PORequest poRequest);

    /**
     * 获取吊牌信息
     * @param poRequest
     * @return
     */
    List<POInfo> getPOTagging(PORequest poRequest);

    /**
     * 获取检针信息
     * @param poRequest
     * @return
     */
    List<POInfo> getPOMetalCheck(PORequest poRequest);

    RuleInfo getRuleInfo(int ruleCode);
}
