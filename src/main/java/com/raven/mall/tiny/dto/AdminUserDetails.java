/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: AdminUserDetails
 * Author:   YuSong
 * Date:     2019/5/25 18:10
 * Description: SpringSecurity需要的用户详情
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import com.raven.mall.tiny.mbg.model.UmsAdmin;
import com.raven.mall.tiny.mbg.model.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <<SpringSecurity需要的用户详情>>
 *
 * @author Raven
 * @version 1.0
 * @description: SpringSecurity需要的用户详情
 * @date 2019/5/25 18:10
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户权限
        return permissionList.stream()
                .filter(permissionList -> permissionList.getValue() != null)
                .map(permissionList -> new SimpleGrantedAuthority(permissionList.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }

}