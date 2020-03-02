package com.nssol.web.dataanalytics.service.sku;

import com.nssol.web.dataanalytics.controller.sku.SKURequest;

public interface SKUService {

    SKUOutput getSKUList(SKURequest skuRequest);
}
