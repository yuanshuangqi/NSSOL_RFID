package com.nssol.web.system.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class MenuInfo extends BaseInfo {

    private Long id;
    /** 菜单code */
    private String menuCode;
    /** 菜单名称 */
    private String menuName;
    /** 菜单URL*/
    private String url;
    /** parentid*/
    private Long parentId = 0L;
    /**菜单图标 */
    private String icon;
    /**是菜单还是按钮 0-菜单;1-按钮 */
    private boolean menuOrBtn;

    private List<MenuInfo> children;
}
