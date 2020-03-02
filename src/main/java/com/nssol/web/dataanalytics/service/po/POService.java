package com.nssol.web.dataanalytics.service.po;

import com.nssol.web.dataanalytics.controller.po.PORequest;

public interface POService {

    POOutput getPOList(PORequest poRequest);
}
