package com.nssol.web.dataanalytics.service.metalcheck;

import com.nssol.web.dataanalytics.model.MetalCheckInfo;
import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MetalCheckOutput extends PageParameter {
    List<MetalCheckInfo> metalCheckData;
}
