package com.nssol.web.system.controller.role;


import com.nssol.web.common.vo.R;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.service.role.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = "角色管理相关API")
@RequestMapping(value = "/api/role")
public class RoleController {
    @Resource
    private IRoleService roleService;
    @PostMapping(value = "/add")
    @ApiOperation("添加角色API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('role_mgr_add')")
    public R addRole(@RequestBody RoleInfo role){
        return roleService.addRole(role);
    }
    @DeleteMapping(value = "/id/{id}")
    @ApiOperation("删除角色API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('role_mgr_del')")
    public R delRoleById(@PathVariable("id")Long id){
        return roleService.delRoleById(id);
    }
    @PutMapping(value = "/edit")
    @ApiOperation("编辑角色API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('role_mgr_edit')")
    public R editRole(@RequestBody RoleInfo role){
        return roleService.editRole(role);
    }
    @PutMapping(value = "menuAssign")
    @ApiOperation("权限分配API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('role_mgr_menu_assign')")
    public R menuAssign(@RequestBody RoleMenuRequest roleMenuRequest){
        return roleService.menuAssign(roleMenuRequest);
    }
    @PostMapping(value = "/list/search")
    public R getRoleData(@RequestBody(required = false) RoleRequest roleRequest){
        return roleService.getRoleData(roleRequest);
    }
    @GetMapping(value = "/list")
    public R getList(){
        return roleService.getList();
    }
}
