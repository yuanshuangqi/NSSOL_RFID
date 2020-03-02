package com.nssol.dao.cluster;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_SET_DETAIL;

@Mapper
public interface ClusterSetDetailDao {

	List<T_SET_DETAIL> selectSetDetail(Timestamp lastTime);

}
