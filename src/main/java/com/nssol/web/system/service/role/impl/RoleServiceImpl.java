package com.nssol.web.system.service.role.impl;

import cn.hutool.core.collection.CollUtil;
import com.nssol.dao.master.RoleDao;
import com.nssol.model.SecurityUser;
import com.nssol.web.common.constants.ResultCodeEnum;
import com.nssol.web.common.vo.R;
import com.nssol.web.system.factory.PageFactory;
import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.model.RoleMenuInfo;
import com.nssol.web.system.service.role.IRoleService;
import com.nssol.web.system.controller.role.RoleMenuRequest;
import com.nssol.web.system.controller.role.RoleRequest;
import com.nssol.web.util.role.RoleUtil;
import com.nssol.web.util.user.UserUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements IRoleService {

    @Resource
    RoleDao roleDao;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    @Override
    public R addRole(RoleInfo roleInfo) {
        try {
            SecurityUser loginUser = UserUtil.getLoginInfo();
            String date = df.format(new Date());
             Date sysDate =  df.parse(date);
            roleInfo.setCreater(loginUser.getUsername());
            roleInfo.setModifyer(loginUser.getUsername());
            roleInfo.setCreateTime(sysDate);
            roleInfo.setModifyTime(sysDate);
            roleInfo.setDel(false);
            roleDao.save(roleInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return R.setResult(ResultCodeEnum.ADD_SUCCESS);
    }
    @Override
    public R delRoleById(Long id) {
       roleDao.deleteRole(id);
       roleDao.deleteUserRole();
        return R.setResult(ResultCodeEnum.DEL_SUCCESS);
    }
    @Override
    public R editRole(RoleInfo roleInfo) {
        try {
            SecurityUser loginUser = UserUtil.getLoginInfo();
            String date = df.format(new Date());
            Date sysDate = df.parse(date);
            //父级角色不能是自身
            if (roleInfo.getId().equals(roleInfo.getParentId())) {
                return R.setResult(ResultCodeEnum.ROLE_NO_SELF);
            }
            List<RoleInfo> children = roleDao.findByParentId(roleInfo.getId());
            if (CollUtil.isNotEmpty(children)) {
                //  父角色不是子角色
                if (children.stream().anyMatch(e -> e.getId().equals(roleInfo.getParentId()))) {
                    return R.setResult(ResultCodeEnum.ROLE_NO_CHILDREN);
                }
            }
            roleInfo.setModifyer(loginUser.getUsername());
            roleInfo.setModifyTime(sysDate);
            roleDao.update(roleInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return R.setResult(ResultCodeEnum.EDIT_SUCCESS);
    }

    @Override
    public R menuAssign(RoleMenuRequest roleMenuRequest) {
        Integer roleId = roleMenuRequest.getRoleId();
        // 删除用户的所有角色信息
        roleDao.deleteRoleMenuById(roleId);
        Integer[] menuIds = roleMenuRequest.getMenuIds();
        List<RoleMenuInfo> roleMenuList = new ArrayList<>();
        for(Integer menuId:menuIds){
            RoleMenuInfo roleMenuInfo = new RoleMenuInfo();
            roleMenuInfo.setRoleId(roleId);
            roleMenuInfo.setMenuId(menuId);
            roleMenuList.add(roleMenuInfo);
        }
            if(menuIds != null && menuIds.length > 0){
                roleDao.insertRoleMenu(roleMenuList);
            }
            return R.setResult(ResultCodeEnum.MENU_ASSIGN_SUCCESS);
    }

    @Override
    public R getRoleData(RoleRequest roleRequest) {

        List<RoleInfo> allRole = roleDao.findRole(roleRequest);
        for(RoleInfo roleInfo:allRole){
            List<MenuInfo> menuInfos = roleDao.findMenuList(roleInfo.getId());
            roleInfo.setMenus(menuInfos);
        }
        // 获取所有父级角色
        List<RoleInfo> parentRoles = allRole.stream().filter(e -> e.getParentId() == 0L).collect(Collectors.toList());
        //递归封装子角色
        for (RoleInfo role : parentRoles) {
            role.setChildren(RoleUtil.getChildren(role,allRole));
        }
        return R.ok().data(PageFactory.createPageMap(parentRoles));
    }
    @Override
    public R getList() {
        RoleRequest roleRequest = new RoleRequest();
        List<RoleInfo> aa = roleDao.findRole(roleRequest);
        return R.ok().data(aa);
    }

}
