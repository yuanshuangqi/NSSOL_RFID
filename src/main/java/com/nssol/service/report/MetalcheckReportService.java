package com.nssol.service.report;


import java.sql.Timestamp;

public interface MetalcheckReportService {

	void synBatch(Timestamp startTime,Timestamp endTime);

}
