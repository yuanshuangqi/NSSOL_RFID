package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_ORDER_DETAIL;
import com.nssol.model.T_PO_INFO;

@Mapper
public interface MasterOrderDetailDao {

	void insert(List<T_ORDER_DETAIL> poList);
	void delete(List<T_PO_INFO> poDetailList);
}
