package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.TBaggingDetail;;

@Mapper
public interface TBaggingDetailDao {

	
	void insertBaggingDetail(TBaggingDetail baggingDetail);
	
	TBaggingDetail selectByEpc(TBaggingDetail baggingDetail);

}