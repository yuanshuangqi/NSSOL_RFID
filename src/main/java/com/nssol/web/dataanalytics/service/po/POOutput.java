package com.nssol.web.dataanalytics.service.po;

import com.nssol.web.dataanalytics.model.POInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class POOutput {
    List<POInfo> poInfoData;
    private int lessETD1;
    private int lessETD2;
}
