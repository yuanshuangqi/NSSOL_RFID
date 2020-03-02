package com.nssol.web.dataanalytics.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetalCheckInfo {

    private String orderNo;
    private String buCode;
    private String skuCode;
    private String sampleCode;
    private String size;
    private String color;
    private String PatternDimensionCode;
    private double orderQty;
    private int scanNum;
}
