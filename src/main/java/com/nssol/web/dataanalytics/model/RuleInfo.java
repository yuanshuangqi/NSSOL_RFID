package com.nssol.web.dataanalytics.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuleInfo {

    private String ruleCode;
    private String ruleName;
    private int lessETD1;
    private int lessETD2;
    private Double percentQty;

}
