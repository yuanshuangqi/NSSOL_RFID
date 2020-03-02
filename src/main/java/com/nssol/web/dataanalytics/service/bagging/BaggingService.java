package com.nssol.web.dataanalytics.service.bagging;

import com.nssol.web.dataanalytics.controller.bagging.BaggingRequest;

import javax.servlet.http.HttpServletResponse;

public interface BaggingService {
    BaggingOutput getBaggingList(BaggingRequest baggingRequest);
    void downloadBagging(BaggingRequest baggingRequest, HttpServletResponse response);
}
