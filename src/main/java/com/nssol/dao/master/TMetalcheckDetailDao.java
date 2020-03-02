package com.nssol.dao.master;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.TMetalcheckDetail;

@Mapper
public interface TMetalcheckDetailDao {

	
	void insertMetalcheckDetail(TMetalcheckDetail metalcheckDetail);
	
	TMetalcheckDetail selectByEpc(TMetalcheckDetail metalcheckDetail);

}