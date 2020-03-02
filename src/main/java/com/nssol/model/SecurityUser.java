package com.nssol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
public class SecurityUser implements UserDetails {
    private  String id;
    private  String username;
    private  String password;
//    private String email;
    private String phone;
    private String token;
    List<SecurityRole> securityRoles = new ArrayList<>();

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return securityRoles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    // 账户是否未过期
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }
    // 账户是否未锁定
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }
    // 密码是否未过期
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 账户是否激活
    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
