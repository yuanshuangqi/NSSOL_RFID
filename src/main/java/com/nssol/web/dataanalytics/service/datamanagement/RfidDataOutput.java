package com.nssol.web.dataanalytics.service.datamanagement;

import com.nssol.web.dataanalytics.model.RfidDataInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RfidDataOutput implements Serializable{
   List<RfidDataInfo> rfidDataInfoList;
}
