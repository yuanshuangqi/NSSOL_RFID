package com.nssol.dao.master;
 

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.TTaggingDetail;

@Mapper
public interface TTaggingDetailDao {

	
	void insertTaggingDetail(TTaggingDetail taggingDetail);
	
	TTaggingDetail selectByEpc(TTaggingDetail taggingDetail);

}