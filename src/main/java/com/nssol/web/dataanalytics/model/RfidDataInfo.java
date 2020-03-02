package com.nssol.web.dataanalytics.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RfidDataInfo implements Serializable {

    /**过程名称*/
    private String processName;
    /*过程总数*/
    private Integer totalCount = 0;

}
