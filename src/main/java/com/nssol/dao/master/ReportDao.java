package com.nssol.dao.master;

import com.nssol.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ReportDao {

	void delete(Timestamp StartTime, Timestamp EndTime);

	void insert(Timestamp StartTime,Timestamp EndTime);

}