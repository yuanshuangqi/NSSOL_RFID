package com.nssol.web.system.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoleInfo extends BaseInfo {

    /** id */
    private Long id;
    /** 角色Code" */
    private String roleCode;
    /** 角色名称" */
    private String roleName;
    /** 角色描述 */
    private String roleDesc;
    /** 父级角色ID */
    private Long parentId = 0L;
    private List<MenuInfo> menus = new ArrayList<>();
    private List<RoleInfo> children;


}
