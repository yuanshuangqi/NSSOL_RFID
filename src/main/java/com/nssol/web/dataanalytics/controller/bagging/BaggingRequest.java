package com.nssol.web.dataanalytics.controller.bagging;

import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaggingRequest extends PageParameter{
    private String orderNo;
    private String skuCode;
    private String sampleCode;
    private String sizeCode;
    private String colorCode;
    private String production;
    private String dateFrom;
    private String dateTo;
}
