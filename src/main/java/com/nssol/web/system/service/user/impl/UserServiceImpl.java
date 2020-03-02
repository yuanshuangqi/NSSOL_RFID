package com.nssol.web.system.service.user.impl;

import cn.hutool.core.collection.CollUtil;

import com.nssol.dao.master.RoleDao;
import com.nssol.dao.master.UserDao;
import com.nssol.model.SecurityUser;
import com.nssol.web.common.constants.ResultCodeEnum;
import com.nssol.web.common.constants.RfidConstants;
import com.nssol.web.common.vo.R;
import com.nssol.web.system.factory.PageFactory;
import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.model.UserInfo;
import com.nssol.web.system.model.UserRoleInfo;
import com.nssol.web.system.controller.user.UserPasswordRequest;
import com.nssol.web.system.controller.user.UserRequest;
import com.nssol.web.system.controller.user.UserRoleRequest;
import com.nssol.web.system.service.user.IUserService;
import com.nssol.web.security.factory.SecurityFactory;
import com.nssol.web.util.menu.MenuUtil;
import com.nssol.web.util.user.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    UserDao userDao;
    @Resource
    RoleDao roleDao;


    private  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


    @Override
    public R addUser(UserInfo user) {
        try {
            SecurityUser loginUser = UserUtil.getLoginInfo();
            String date = df.format(new Date());
            Date sysDate = df.parse(date);
            user.setPassword(UserUtil.getEncryptPassword());
            user.setId(UserUtil.getUUID());
            user.setCreater(loginUser.getUsername());
            user.setModifyer(loginUser.getUsername());
            user.setCreateTime(sysDate);
            user.setModifyTime(sysDate);
            userDao.insertUser(user);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return R.setResult(ResultCodeEnum.ADD_SUCCESS);
    }

    @Override
    public R editUser(UserInfo user) {
        try {
         SecurityUser loginUser = UserUtil.getLoginInfo();
        String date = df.format(new Date());
        Date sysDate = df.parse(date);
        user.setModifyer(loginUser.getUsername());
        user.setModifyTime(sysDate);
        userDao.updateUser(user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return R.setResult(ResultCodeEnum.EDIT_SUCCESS);
    }

    @Override
    public R userRoleAssign(UserRoleRequest userRoleRequest) {

        String userId = userRoleRequest.getId();
            // 删除用户的所有角色信息
        userDao.deleteUserRoleById(userId);
        Integer[] roleIds = userRoleRequest.getRoleIds();
        List<UserRoleInfo> userRoleList = new ArrayList<>();
        for(Integer roleId:roleIds){
            UserRoleInfo userRoleInfo = new UserRoleInfo();
            userRoleInfo.setUserId(userId);
            userRoleInfo.setRoleId(roleId);
            userRoleList.add(userRoleInfo);
        }
        if(roleIds != null && roleIds.length > 0) {
            userDao.insertUserRole(userRoleList);
        }
            return R.setResult(ResultCodeEnum.ROLE_ASSIGN_SUCCESS);

    }

    @Override
    public R delUserByUserId(String id) {
        userDao.delUser(id);
        userDao.delUserRole();
        return R.setResult(ResultCodeEnum.DEL_SUCCESS);
    }

    @Override
    public R getUserData(UserRequest userRequest) {
        List<UserInfo> userInfoList = userDao.findUser(userRequest);
        for(UserInfo userInfo:userInfoList){
            List<RoleInfo> roleInfos = userDao.findRoleList(userInfo.getId());
            userInfo.setRoles(roleInfos);
        }
        return R.ok().data(PageFactory.createPageMap(userInfoList));
    }

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return R
     */
    @Override
    public R getUserInfoByUsername(String username) {
        UserInfo user = userDao.findUserByName(username);
        List<RoleInfo> roles = userDao.findRoleList(user.getId());
        for(RoleInfo role:roles){
            List<MenuInfo> menuInfos = roleDao.findMenuList(role.getId());
            role.setMenus(menuInfos);
        }
        user.setRoles(roles);
        //密码重置为null
        user.setPassword(null);
        if(CollUtil.isEmpty(roles)){ // 用户没有系统的任何角色，那么无法进入系统
            return R.setResult(ResultCodeEnum.USER_NO_PERMISSION);
        }
        //根据用户的角色，生成用户的菜单和按钮权限树,并根据ID去除重复的
        ArrayList<MenuInfo> menus = roles.stream().map(RoleInfo::getMenus).flatMap(Collection::stream).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MenuInfo::getId))), ArrayList::new));
        //获取所有的父级菜单
        List<MenuInfo> parentMenus = menus.stream().filter(e -> e.getParentId() == 0L).collect(Collectors.toList());
        //递归封装子菜单
        for (MenuInfo parentMenu : parentMenus) {
            //此方法为加载用户所具有的菜单权限，故不能加载按钮权限
            MenuInfo menu1 = new MenuInfo();
            parentMenu.setChildren(MenuUtil.getChildrenNoBtn(parentMenu,menus));
        }
        user.setTreeMenus(parentMenus);
        user.setAllMenus(menus);
        return R.ok().data(user);
    }

    @Override
    @Transactional
    public SecurityUser getUserRolesByUsername(String username) {
        UserInfo user = userDao.findUserByName(username);
        List<RoleInfo> roles = userDao.findRoleList(user.getId());
        for(RoleInfo role:roles){
            List<MenuInfo> menuInfos = roleDao.findMenuList(role.getId());
            role.setMenus(menuInfos);
        }
        user.setRoles(roles);
        return  SecurityFactory.create(user);
    }

    @Override
    public R updateUserPwd(UserPasswordRequest userPasswordRequest) {
        SecurityUser loginUser = UserUtil.getLoginInfo();
        String oldPas = UserUtil.getEncryptPassword(userPasswordRequest.getOldPassword());
        String newPas = UserUtil.getEncryptPassword(userPasswordRequest.getNewPassword());
        Integer res = userDao.editPas(oldPas,newPas,loginUser.getId());
        if(res != 1){
            return R.error().message(RfidConstants.PASSWORD_ERROR);
        }
        return R.ok();
    }

    @Override
    public R resetUserPassword(String userId) {
        String password = UserUtil.getEncryptPassword("123456");
        Integer res = userDao.restPasById(password,userId);
        if(res != 1){
            return R.error();
        }
        return R.ok();
    }
}
