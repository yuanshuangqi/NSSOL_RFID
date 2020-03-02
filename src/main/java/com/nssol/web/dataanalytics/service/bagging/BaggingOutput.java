package com.nssol.web.dataanalytics.service.bagging;

import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BaggingOutput extends PageParameter{
    private List<BaggingInfo> baggingData;
}
