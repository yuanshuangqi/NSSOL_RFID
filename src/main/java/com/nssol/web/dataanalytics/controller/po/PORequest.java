package com.nssol.web.dataanalytics.controller.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PORequest {
    private String orderNo;
    private String dicType;
    private String dateFrom;
    private String dateTo;
}
