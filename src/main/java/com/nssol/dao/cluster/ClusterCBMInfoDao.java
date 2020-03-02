package com.nssol.dao.cluster;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_CBM_INFO;

@Mapper
public interface ClusterCBMInfoDao {

	List<T_CBM_INFO> selectAllCBM(Timestamp lastTime);
}
