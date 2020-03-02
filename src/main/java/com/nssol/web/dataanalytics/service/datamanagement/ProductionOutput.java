package com.nssol.web.dataanalytics.service.datamanagement;

import com.nssol.web.dataanalytics.model.ProductionInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductionOutput {
    private List<ProductionInfo> productionInfoList;
}
