package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_Bagging;

@Mapper
public interface TBaggingDao {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table public.users
	 *
	 * @mbg.generated Mon Jan 15 14:03:52 CST 2018
	 */
	List<T_Bagging> selectByCriteria(T_Bagging tBagging);
	
	void insertBagging(T_Bagging tBagging);

	List<T_Bagging> selectBagginglist(T_Bagging tBagging);
	
	List<T_Bagging> selectTotBagginglist(T_Bagging tBagging);
	
	List<T_Bagging> selectBagginglistCount(T_Bagging tBagging);
	
	T_Bagging selectIdBysku(T_Bagging tBagging);
	
	void updateBagging(T_Bagging tBagging);
}