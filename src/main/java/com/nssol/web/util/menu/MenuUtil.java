package com.nssol.web.util.menu;

import cn.hutool.core.collection.CollUtil;
import com.nssol.web.system.model.MenuInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单模块工具类
 */
public class MenuUtil {
    public static List<MenuInfo> getChildrenWithBtn(MenuInfo parentMenu, List<MenuInfo> menus) {
        List<MenuInfo> children = new ArrayList<>();
        for (MenuInfo menu : menus) {
            if(menu.getParentId().equals(parentMenu.getId())){
                children.add(menu);
            }
        }
        if(CollUtil.isNotEmpty(children)){
            for (MenuInfo child : children) {
                child.setChildren(getChildrenWithBtn(child,menus));
            }
        }
        return children;

    }
    public static List<MenuInfo> getChildrenNoBtn(MenuInfo parentMenu, List<MenuInfo> menus) {
        List<MenuInfo> children = new ArrayList<>();
        for (MenuInfo menu : menus) {
            if(menu.getParentId().equals(parentMenu.getId()) && !menu.isMenuOrBtn()){
                children.add(menu);
            }
        }
        if(CollUtil.isNotEmpty(children)){
            for (MenuInfo child : children) {
                child.setChildren(getChildrenNoBtn(child,menus));
            }
        }
        return children;

    }
}
