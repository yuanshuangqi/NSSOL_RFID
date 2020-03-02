package com.nssol.web.system.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRoleInfo extends BaseInfo {

    /** 用户id */
    private String userId;
    /** 角色ID" */
    private Integer roleId;
}
