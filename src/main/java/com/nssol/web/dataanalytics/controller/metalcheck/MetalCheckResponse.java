package com.nssol.web.dataanalytics.controller.metalcheck;

import com.nssol.web.dataanalytics.model.MetalCheckInfo;
import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MetalCheckResponse extends PageParameter{
    List<MetalCheckInfo> metalCheckData;
}
