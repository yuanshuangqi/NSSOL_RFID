package com.nssol.service;


import java.util.List;

import com.nssol.model.TMstDictionary;

public interface TMstDictionaryService {

	public List<TMstDictionary> getMstDictionary(TMstDictionary mstDict) ;

	public List<TMstDictionary> getEnableAddress(TMstDictionary mstDict) ;

	public void setMstDictionary(TMstDictionary mstDict) ;

	public void clearAddress(TMstDictionary mstDict) ;
}
