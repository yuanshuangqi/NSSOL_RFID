package com.nssol.web.dataanalytics.service.order;

import com.nssol.web.dataanalytics.model.OrderInfo;
import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderOutput extends PageParameter{
    List<OrderInfo> orderData;
}
