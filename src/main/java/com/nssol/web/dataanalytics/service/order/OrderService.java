package com.nssol.web.dataanalytics.service.order;

import com.nssol.web.dataanalytics.controller.order.OrderRequest;

import javax.servlet.http.HttpServletResponse;

public interface OrderService {
    OrderOutput getOrderList(OrderRequest orderRequest);
    void downloadOrder(OrderRequest orderRequest, HttpServletResponse response);
}
