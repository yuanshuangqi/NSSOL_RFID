package com.nssol.common.model;

import java.io.Serializable;

public class PagingResult implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -6220417594543452628L;

	/** totalCount */
    private long totalCount;

    /** offset */
    private long offset;

    /** limit */
    private int limit;

    /**
     * the getter of totalCount.
     *
     * @return the totalCount
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * the setter of totalCount.
     *
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * the getter of offset.
     *
     * @return the offset
     */
    public long getOffset() {
        return offset;
    }

    /**
     * the setter of offset.
     *
     * @param offset the offset to set
     */
    public void setOffset(long offset) {
        this.offset = offset;
    }

    /**
     * the getter of limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * the setter of limit.
     *
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }
}
