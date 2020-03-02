package com.nssol.web.dataanalytics.service.sku;

import com.nssol.web.dataanalytics.model.SKUInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SKUOutput {
    List<SKUInfo> skuInfoData;
}
