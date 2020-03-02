package com.nssol.web.dataanalytics.controller.po;

import com.nssol.web.dataanalytics.model.POInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class POResponse {
    List<POInfo> poInfoData;
    private int lessETD1;
    private int lessETD2;
}
