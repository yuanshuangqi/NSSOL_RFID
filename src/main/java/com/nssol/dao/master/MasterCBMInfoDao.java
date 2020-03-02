package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_CBM_INFO;

@Mapper
public interface MasterCBMInfoDao {

	void insert(List<T_CBM_INFO> poList);
	void delete(List<T_CBM_INFO> poList);
}
