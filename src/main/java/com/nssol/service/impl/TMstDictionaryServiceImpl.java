package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TMstDictionaryDao;
import com.nssol.model.TMstDictionary;
import com.nssol.service.TMstDictionaryService;


@Service
@Transactional
public class TMstDictionaryServiceImpl implements TMstDictionaryService {

	@Autowired
	private TMstDictionaryDao mstDictionary;

	@Override
	public List<TMstDictionary> getMstDictionary(TMstDictionary mstDict) {

		List<TMstDictionary> dict = mstDictionary.getMstDictionary(mstDict);
		return dict;
	}

	@Override
	public List<TMstDictionary> getEnableAddress(TMstDictionary mstDict) {

		List<TMstDictionary> dict = mstDictionary.getEnableAddress(mstDict);
		return dict;
	}

	@Override
	public void setMstDictionary(TMstDictionary mstDict) {

		mstDictionary.setMstDictionary(mstDict);
	}

	@Override
	public void clearAddress(TMstDictionary mstDict) {

		mstDictionary.clearAddress(mstDict);
	}
}
