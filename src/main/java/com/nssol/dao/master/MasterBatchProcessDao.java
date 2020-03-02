package com.nssol.dao.master;

import com.nssol.model.T_BATCH_PROCESS;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MasterBatchProcessDao {

	void updateProcessFlag(T_BATCH_PROCESS t_batch_process);

	T_BATCH_PROCESS getLastTime(String batchId);

	void insert(T_BATCH_PROCESS batch_process);
}
