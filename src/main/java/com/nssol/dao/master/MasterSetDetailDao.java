package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_SET_DETAIL;

@Mapper
public interface MasterSetDetailDao {

	void delete(List<T_SET_DETAIL> insertSetDetailList);

	void insert(List<T_SET_DETAIL> insertSetDetailList);

}
