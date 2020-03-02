package com.nssol.web.dataanalytics.controller.sku;

import com.nssol.web.dataanalytics.model.POInfo;
import com.nssol.web.dataanalytics.model.SKUInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SKUResponse {
    List<SKUInfo> skuInfoData;
}
