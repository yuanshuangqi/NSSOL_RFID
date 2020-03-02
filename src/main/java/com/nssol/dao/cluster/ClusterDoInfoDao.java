package com.nssol.dao.cluster;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_DO_INFO;

@Mapper
public interface ClusterDoInfoDao {

	List<T_DO_INFO> selectAll(Timestamp lastTime);
}
