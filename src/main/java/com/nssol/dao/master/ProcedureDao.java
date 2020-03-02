package com.nssol.dao.master;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProcedureDao {

	void backUpBaggingAndMetalcheck(Map<String, Object> map);
}
