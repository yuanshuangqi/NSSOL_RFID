package com.nssol.web.dataanalytics.controller.datamanagement;

import com.nssol.web.dataanalytics.model.ProductionInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductionResponse {
    private List<ProductionInfo> productionInfoList;

}
