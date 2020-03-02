package com.nssol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.system.model.RoleInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SecurityRole implements GrantedAuthority {
    private Long id;
    private String roleCode;
    private String roleName;
    private String roleDesc;
    private List<MenuInfo> menus = new ArrayList<>();
    public SecurityRole(MenuInfo menu) {
        this.id = menu.getId();
        this.roleCode = menu.getMenuCode();
        this.roleName = menu.getMenuName();
    }

    public SecurityRole(RoleInfo role) {
        this.id = role.getId();
        this.roleCode = role.getRoleCode();
        this.roleName = role.getRoleName();
        this.roleDesc = role.getRoleDesc();
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return roleCode;
    }
}
