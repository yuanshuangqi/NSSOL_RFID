package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.model.TMstDictionary;

public class TMstDictionaryResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<TMstDictionary> dictionaryList;

	public List<TMstDictionary> getDictionaryList() {
		return dictionaryList;
	}

	public void setDictionaryList(List<TMstDictionary> dictionaryList) {
		this.dictionaryList = dictionaryList;
	}

}
