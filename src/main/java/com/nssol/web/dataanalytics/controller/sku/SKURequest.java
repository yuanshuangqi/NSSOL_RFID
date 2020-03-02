package com.nssol.web.dataanalytics.controller.sku;

import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SKURequest extends PageParameter{
    private String skuCode;
    private String sizeCode;
    private String colorCode;
    private String dicType;
}
