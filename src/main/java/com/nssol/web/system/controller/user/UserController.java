package com.nssol.web.system.controller.user;


import com.nssol.web.common.vo.R;
import com.nssol.web.system.model.UserInfo;
import com.nssol.web.system.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = "用户管理相关API")
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private IUserService userService;

    @PostMapping(value = "/add")
    @ApiOperation("添加用户API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('user_mgr_add') ")
    public R addUser(@RequestBody UserInfo user){
        return userService.addUser(user);
    }

    @DeleteMapping(value = "/id/{id}")
    @ApiOperation("删除用户API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('user_mgr_del') ")
    public R delUserById(@PathVariable("id")String id){
        return userService.delUserByUserId(id);
    }

    @PutMapping(value = "/edit")
    @ApiOperation("编辑用户API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('user_mgr_edit') ")
    public R editUser(@RequestBody UserInfo user){
        return userService.editUser(user);
    }

    @PostMapping(value = "/list")
    @ApiOperation("查询用户API")
    public R getUserData(@RequestBody UserRequest userRequest){
        return userService.getUserData(userRequest);
    }

    @GetMapping(value = "/username/{username}")
    @ApiOperation(value = "根据用户登录账号查询用户API")
    public R getUserInfoByUsername(@PathVariable("username")String username){
        return userService.getUserInfoByUsername(username);
    }

    @PutMapping(value = "/roleAssign")
    @ApiOperation(value = "角色分配API")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') && hasAuthority('user_mgr_role_assign') ")
    public R userRoleAssign(@RequestBody UserRoleRequest userRoleRequest){
        return userService.userRoleAssign(userRoleRequest);
    }
    @PostMapping(value = "/updateUserPwd")
    @ApiOperation(value = "修改密码")
    public R updateUserPwd(@RequestBody UserPasswordRequest userPasswordRequest){
        return userService.updateUserPwd(userPasswordRequest);
    }

    @GetMapping(value = "/resetPwd/{userId}")
    @ApiOperation(value = "根据用户账号重置密码")
    public R resetUserPassword(@PathVariable("userId")String userId){
        return userService.resetUserPassword(userId);
    }
}
