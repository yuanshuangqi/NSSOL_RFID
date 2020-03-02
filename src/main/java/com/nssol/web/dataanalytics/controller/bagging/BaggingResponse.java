package com.nssol.web.dataanalytics.controller.bagging;

import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BaggingResponse extends PageParameter{
    private List<BaggingInfo> baggingData;
}
