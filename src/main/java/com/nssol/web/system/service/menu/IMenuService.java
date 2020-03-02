package com.nssol.web.system.service.menu;


import com.nssol.web.common.vo.R;
import com.nssol.web.system.controller.menu.MenuRequest;
import com.nssol.web.system.model.MenuInfo;

public interface IMenuService {
    R addMenu(MenuInfo menuInfo);

    R delMenuById(Long id);

    R editMenu(MenuInfo menuInfo);

    R getMenuData(MenuRequest menuRequest);

    R getList();
}
