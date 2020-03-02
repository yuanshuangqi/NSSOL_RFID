package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_SET_INFO;

@Mapper
public interface MasterSetInfoDao {

	void deleteSetInfo(List<T_SET_INFO> list);

	void insertSetInfo(List<T_SET_INFO> list);
	
}
