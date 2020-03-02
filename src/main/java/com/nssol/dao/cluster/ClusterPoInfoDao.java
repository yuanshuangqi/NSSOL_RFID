package com.nssol.dao.cluster;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_PO_INFO;

@Mapper
public interface ClusterPoInfoDao {

	List<T_PO_INFO> selectAll(Timestamp lastTime);
}
