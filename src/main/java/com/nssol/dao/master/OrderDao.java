package com.nssol.dao.master;

import cn.hutool.db.sql.Order;
import com.nssol.web.dataanalytics.controller.bagging.BaggingRequest;
import com.nssol.web.dataanalytics.controller.order.OrderRequest;
import com.nssol.web.dataanalytics.controller.po.PORequest;
import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.web.dataanalytics.model.OrderInfo;
import com.nssol.web.dataanalytics.model.POInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * 获取订单总数
     * @param orderRequest
     * @return
     */
    Long getOrderTotalCount(OrderRequest orderRequest);

    /**
     * 获取orderInfoList
     * @param orderRequest
     * @return
     */
    List<OrderInfo> getOrderList(OrderRequest orderRequest);
}
