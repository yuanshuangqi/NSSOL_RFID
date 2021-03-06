package com.nssol.dao.cluster;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_SET_DETAIL;
import com.nssol.model.T_SET_INFO;

@Mapper
public interface ClusterSetInfoDao {
	List<T_SET_INFO> selectSetInfo(Timestamp lastTime);
	
}
