package com.nssol.dao.master;

import com.nssol.web.dataanalytics.controller.po.PORequest;
import com.nssol.web.dataanalytics.controller.sku.SKURequest;
import com.nssol.web.dataanalytics.model.POInfo;
import com.nssol.web.dataanalytics.model.RuleInfo;
import com.nssol.web.dataanalytics.model.SKUInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SKUDao {
    /**
     * 获取包装信息
     * @param skuRequest
     * @return
     */
    List<SKUInfo> getSKUBagging(SKURequest skuRequest);

    /**
     * 获取吊牌信息
     * @param skuRequest
     * @return
     */
    List<SKUInfo> getSKUTagging(SKURequest skuRequest);

    /**
     * 获取检针信息
     * @param skuRequest
     * @return
     */
    List<SKUInfo> getSKUMetalCheck(SKURequest skuRequest);

}
