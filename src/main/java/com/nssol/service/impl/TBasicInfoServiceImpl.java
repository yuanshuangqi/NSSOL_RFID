package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TBasicInfoDao;
import com.nssol.model.TBasicInfo;
import com.nssol.service.TBasicInfoService;


@Service
@Transactional
public class TBasicInfoServiceImpl implements TBasicInfoService {

	@Autowired
	private TBasicInfoDao basicInfoDao;

	@Override
	public List<TBasicInfo> getBasicInfo(TBasicInfo basicInfo) {

		List<TBasicInfo> dict = basicInfoDao.selectByskuCode(basicInfo);
		return dict;
	}
}
