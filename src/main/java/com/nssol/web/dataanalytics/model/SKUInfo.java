package com.nssol.web.dataanalytics.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SKUInfo {
    private String skuCode;
    private String colorCode;
    private String color;
    private String sizeCode;
    private String size;
    private int orderQty;
    private int scanNum;
    private int blueQty;
    private int redQty;
}
