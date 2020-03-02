package com.nssol.web.security.factory;



import com.nssol.model.SecurityRole;
import com.nssol.model.SecurityUser;
import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.model.UserInfo;


import java.util.*;
import java.util.stream.Collectors;

public class SecurityFactory {
    //私有化构造器
    private SecurityFactory() {
    }
    public static SecurityUser login(UserInfo user){
        SecurityUser securityUser =new SecurityUser();
        securityUser.setUsername(user.getAccount());
        securityUser.setPassword(user.getPassword());
        return securityUser;
    }
    public static SecurityUser login(SecurityUser securityUser){
        SecurityUser user =new SecurityUser();
        user.setUsername(securityUser.getUsername());
        return user;
    }
    public static SecurityUser create(UserInfo user){
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUsername(user.getAccount());
        securityUser.setPassword(user.getPassword());
        securityUser.setId(user.getId());
//        securityUser.setEmail(user.getEmail());
        securityUser.setPhone(user.getPhone());
        List<RoleInfo> roles = user.getRoles();
        for (RoleInfo role : roles) {
            SecurityRole securityRole = new SecurityRole(role);
            securityUser.getSecurityRoles().add(securityRole);
        }
        List<MenuInfo> menus = roles.stream().map(RoleInfo::getMenus).flatMap(Collection::stream).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MenuInfo::getId))), ArrayList::new));
        for (MenuInfo menu : menus) {
            SecurityRole securityRole = new SecurityRole(menu);
            securityUser.getSecurityRoles().add(securityRole);
        }
        return securityUser;
    }
    public static SecurityUser create(SecurityUser user){
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUsername(user.getUsername());
        securityUser.setPassword(user.getPassword());
//        securityUser.setEmail(user.getEmail());
        securityUser.setPhone(user.getPhone());
       securityUser.setSecurityRoles(user.getSecurityRoles());
        return securityUser;
    }
}
