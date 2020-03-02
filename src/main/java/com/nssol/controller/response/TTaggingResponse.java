package com.nssol.controller.response;

import java.io.Serializable;
import java.util.List;

import com.nssol.common.model.PageUtils;
import com.nssol.model.T_Bagging;
import com.nssol.model.T_Tagging;;

public class TTaggingResponse implements Serializable {

	private static final long serialVersionUID = -2201900316948335771L;

	private List<T_Tagging> taggingList;

	public List<T_Tagging> getTaggingList() {
		return taggingList;
	}

	public void setTaggingList(List<T_Tagging> tagList) {
		this.taggingList = tagList;
	}
}
