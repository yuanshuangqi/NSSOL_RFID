package com.nssol.web.system.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class BaseInfo {
    /**
     * 创建者
     */
    private String creater;
    /**
     * 创建时间
     */
    private Date createTime ;

    /**
     * 更新者
     */
    private String modifyer;

    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 逻辑删除
     */
    private boolean isDel = false;
}
