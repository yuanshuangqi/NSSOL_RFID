package com.nssol.web.system.service.menu.impl;

import cn.hutool.core.collection.CollUtil;

import com.nssol.dao.master.MenuDao;
import com.nssol.model.SecurityUser;
import com.nssol.web.common.constants.ResultCodeEnum;
import com.nssol.web.common.vo.R;
import com.nssol.web.system.factory.PageFactory;
import com.nssol.web.system.service.menu.IMenuService;
import com.nssol.web.system.controller.menu.MenuRequest;
import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.util.menu.MenuUtil;
import com.nssol.web.util.user.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements IMenuService {
    @Resource
    MenuDao menuDao;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


    @Override
    public R addMenu(MenuInfo menuInfo) {
        try {
        SecurityUser loginUser = UserUtil.getLoginInfo();
        String date = df.format(new Date());
        Date sysDate = df.parse(date);
        menuInfo.setCreater(loginUser.getUsername());
        menuInfo.setModifyer(loginUser.getUsername());
        menuInfo.setCreateTime(sysDate);
        menuInfo.setModifyTime(sysDate);
        menuInfo.setDel(false);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        menuDao.save(menuInfo);
        return R.setResult(ResultCodeEnum.ADD_SUCCESS);
    }

    @Override
    @Transactional
    public R delMenuById(Long id) {
        if(!ObjectUtils.isEmpty(id)) {
            menuDao.deleteMenu(id);
            menuDao.deleteRoleMenu();
        }
        return R.setResult(ResultCodeEnum.DEL_SUCCESS);
    }

    @Override
    public R editMenu(MenuInfo menu) {
        try {
        SecurityUser loginUser = UserUtil.getLoginInfo();
        String date = df.format(new Date());
        Date sysDate = df.parse(date);

        //父级菜单不能是自身
        if(menu.getId().equals(menu.getParentId())){
            return R.setResult(ResultCodeEnum.MENU_NO_SELF);
        }
       // List<Menu> children = menuRepository.findByParentIdEquals(menu.getId());
        List<MenuInfo> children = menuDao.findByParentId(menu.getId());
        if(CollUtil.isNotEmpty(children)){
            //父级菜单不能是子菜单
            if(children.stream().anyMatch(e->e.getId().equals(menu.getParentId()))){
                return R.setResult(ResultCodeEnum.MENU_NO_CHILDREN);
            }
        }
            menu.setModifyer(loginUser.getUsername());
            menu.setModifyTime(sysDate);
            menuDao.update(menu);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return R.setResult(ResultCodeEnum.EDIT_SUCCESS);
    }

    @Override
    public R getMenuData(MenuRequest menuRequest) {
        List<MenuInfo> allMenus = menuDao.findMenu(menuRequest);
        //获取所有父级菜单
        List<MenuInfo> parentMenus = allMenus.stream().filter(e -> e.getParentId() == 0L).collect(Collectors.toList());
        if(CollUtil.isNotEmpty(parentMenus)){
            //递归封装子角色
            for (MenuInfo menu : parentMenus) {
                //此方法为加载所有菜单和按钮权限，故需要加载相应的按钮权限
                menu.setChildren(MenuUtil.getChildrenWithBtn(menu,allMenus));
            }
            return R.ok().data(PageFactory.createPageMap(parentMenus));
        }else {
            return R.ok().data(PageFactory.createPageMap(allMenus));
        }

    }

    @Override
    public R getList() {
        MenuRequest menuRequest = new MenuRequest();
        List<MenuInfo> menuInfos = menuDao.findMenu(menuRequest);
        return R.ok().data(menuInfos);
    }
}
