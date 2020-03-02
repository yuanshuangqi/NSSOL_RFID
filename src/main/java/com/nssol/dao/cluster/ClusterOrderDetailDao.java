package com.nssol.dao.cluster;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_ORDER_DETAIL;

@Mapper
public interface ClusterOrderDetailDao {

	List<T_ORDER_DETAIL> selectAll(Timestamp lastTime);
}
