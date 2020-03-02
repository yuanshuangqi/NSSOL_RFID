package com.nssol.web.dataanalytics.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class POInfo {
    private String orderNo;
    private String ETD;
    private int orderQty;
    private int scanNum;
    private int blueQty;
    private int yellowQty;
    private int orangeQty;
    private int redQty;
}
