package com.nssol.web.dataanalytics.model;

import java.io.Serializable;

public class PagingResult implements Serializable{

    /**
     * totalCount
     */
    private long totalCount;

    /**
     * offset
     */
    private long offset;

    /**
     * limit
     */
    private int limit;
}
