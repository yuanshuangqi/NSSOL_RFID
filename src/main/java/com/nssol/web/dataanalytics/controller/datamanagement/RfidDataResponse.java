package com.nssol.web.dataanalytics.controller.datamanagement;

import com.nssol.web.dataanalytics.model.RfidDataInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RfidDataResponse {
    List<RfidDataInfo> rfidDataInfoList;
}
