package com.nssol.web.dataanalytics.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderInfo {
    private String orderNo;
    private String ETD;
    private String buCode;
    private String skuCode;
    private String sampleCode;
    private String size;
    private String color;
    private String PatternDimensionCode;
    private double orderQty;
    private int baggingQty;
    private int metalCheckQty;
}
