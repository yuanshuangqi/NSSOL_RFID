package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_PO_INFO;

@Mapper
public interface MasterPoInfoDao {

	void insert(List<T_PO_INFO> poList);
	void delete(List<T_PO_INFO> poList);
}
