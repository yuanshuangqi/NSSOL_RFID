package com.nssol.web.system.controller.menu;


import com.nssol.web.common.vo.R;
import com.nssol.web.system.service.menu.IMenuService;
import com.nssol.web.system.model.MenuInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = "菜单管理相关API")
@RequestMapping(value = "/api/menu")
public class MenuController {
    @Resource
    private IMenuService menuService;

    @PostMapping(value = "/add")
    @ApiOperation("添加菜单API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('menu_mgr_add')")
    public R addMenu(@RequestBody MenuInfo menuInfo){
        return menuService.addMenu(menuInfo);
    }
    @DeleteMapping(value = "/id/{id}")
    @ApiOperation("删除菜单API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('menu_mgr_del')")
    public R delMenuById(@PathVariable("id")Long id){
        return menuService.delMenuById(id);
    }
    @PutMapping(value = "/edit")
    @ApiOperation("编辑菜单API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('menu_mgr_edit')")
    public R editMenu(@RequestBody MenuInfo menu){
        return menuService.editMenu(menu);
    }
    @PostMapping(value = "/list/search")
    public R getMenuData(@RequestBody(required = false) MenuRequest menuRequest){
        return menuService.getMenuData(menuRequest);
    }

    @GetMapping(value = "/list")
    public R getList(){
        return menuService.getList();
    }
}
