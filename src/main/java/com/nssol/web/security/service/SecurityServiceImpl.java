package com.nssol.web.security.service;



import com.nssol.dao.master.RoleDao;
import com.nssol.dao.master.UserDao;
import com.nssol.web.common.constants.ResultCodeEnum;
import com.nssol.web.common.exception.SkyBootException;
import com.nssol.web.security.factory.SecurityFactory;
import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.model.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SecurityServiceImpl implements UserDetailsService {
    @Resource
    UserDao userDao;
    @Resource
    RoleDao roleDao;
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        UserInfo user = userDao.findUserByName(account);
        List<RoleInfo> roles = userDao.findRoleList(user.getId());
        for(RoleInfo role:roles){
            List<MenuInfo> menuInfos = roleDao.findMenuList(role.getId());
            role.setMenus(menuInfos);
        }
        user.setRoles(roles);
        if(user == null){
            throw new SkyBootException(ResultCodeEnum.ACCOUNT_UNKNOWN);
        }
        return SecurityFactory.login(user);
    }
}
