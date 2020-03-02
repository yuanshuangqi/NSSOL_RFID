package com.nssol.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PageParameter implements Serializable {
    /**
     * 当前页
     */
    private Integer currentPage = 1;
    /**
     * 每页显示条数
     */
    private Integer pageSize = 20;
    /**
     * 总条数
     */
    private long total;
    /**
     * pageStart
     */
    private Integer pageStart;

    /**
     * pageEnd
     */
    private Integer pageEnd;
}
