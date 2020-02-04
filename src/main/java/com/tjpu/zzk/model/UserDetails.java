package com.tjpu.zzk.model;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {
    //获取用户的权限集合
    Collection<? extends GrantedAuthority> getAuthorities();

    //获取密码
    String getPassword();

    //获取用户名
    String getUsername();

    //账号是否没过期
    boolean isAccountNonExpired();

    //账号是否没被锁定
    boolean isAccountNonLocked();

    //密码是否没过期
    boolean isCredentialsNonExpired();

    //账户是否可用
    boolean isEnabled();
}
