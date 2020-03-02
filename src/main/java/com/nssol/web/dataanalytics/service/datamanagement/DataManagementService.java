package com.nssol.web.dataanalytics.service.datamanagement;


import com.nssol.web.dataanalytics.controller.datamanagement.ProductionRequest;

public interface DataManagementService {
    /**get Frid data*/
    RfidDataOutput getRfidData(ProductionRequest productionRequest);
    ProductionOutput getProduction(ProductionRequest request);
}
