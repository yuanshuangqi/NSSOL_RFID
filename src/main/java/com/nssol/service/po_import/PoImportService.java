package com.nssol.service.po_import;

import java.util.Map;

public interface PoImportService {

	void synBatch();
	
	void backUpBaggingAndMetalcheck(Map<String, Object> map);
}
