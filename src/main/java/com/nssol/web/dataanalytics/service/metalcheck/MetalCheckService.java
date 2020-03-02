package com.nssol.web.dataanalytics.service.metalcheck;

import com.nssol.web.dataanalytics.controller.metalcheck.MetalCheckRequest;

import javax.servlet.http.HttpServletResponse;

public interface MetalCheckService {
    MetalCheckOutput getMetalCheckList(MetalCheckRequest metalCheckRequest);
    void downloadMetalCheck(MetalCheckRequest metalCheckRequest, HttpServletResponse response);
}
