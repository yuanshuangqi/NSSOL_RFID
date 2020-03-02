package com.nssol.dao.master;

import com.nssol.model.TMetalcheck;
import com.nssol.model.TMetalcheckDetail;
import com.nssol.model.TMetalcheckSensitivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TMetalcheckSensitivityDao {

	
	void updateMetalcheckSensitivity(TMetalcheckSensitivity metalcheckSensitivity);

	TMetalcheckSensitivity selectLatestSensitivity(TMetalcheck metalcheck);

	void insertMetalcheckSensitivity(TMetalcheck metalcheck);

	List<TMetalcheckSensitivity> selectSensitivityList(TMetalcheck metalcheck);
}