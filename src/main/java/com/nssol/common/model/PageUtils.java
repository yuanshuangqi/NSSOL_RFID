package com.nssol.common.model;

import java.io.Serializable;
import java.util.List;

public class PageUtils implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6220417594543452628L;

	
	/// <summary>
    /// 总页数
    /// </summary>
	  private Integer pagesCount=0;
	  
	/// <summary>
      /// 记录总数
      /// </summary>
      private Integer recordCounts = 0;
     
    /// <summary>
      /// 当前页记录数
      /// </summary>
      private Integer currentPageRecordCounts=0;
    
      /// <summary>
      /// 当前页显示行数
      /// </summary>
      private Integer currentPageShowCounts = 20;
     
      /// <summary>
      /// 当前页数
      /// </summary>
      private Integer currentPageNumber=0;
      
	  public Integer getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(Integer pagesCount) {
		this.pagesCount = pagesCount;
	}

	public Integer getRecordCounts() {
		return recordCounts;
	}

	public void setRecordCounts(Integer recordCounts) {
		this.recordCounts = recordCounts;
	}

	public Integer getCurrentPageRecordCounts() {
		return currentPageRecordCounts;
	}

	public void setCurrentPageRecordCounts(Integer currentPageRecordCounts) {
		this.currentPageRecordCounts = currentPageRecordCounts;
	}

	public Integer getCurrentPageShowCounts() {
		return currentPageShowCounts;
	}

	public void setCurrentPageShowCounts(Integer currentPageShowCounts) {
		this.currentPageShowCounts = currentPageShowCounts;
	}

	public Integer getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(Integer currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

}

