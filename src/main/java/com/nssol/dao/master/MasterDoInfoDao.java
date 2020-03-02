package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_DO_INFO;

@Mapper
public interface MasterDoInfoDao {

	void insert(List<T_DO_INFO> poList);
	void delete(List<T_DO_INFO> doList);
}
