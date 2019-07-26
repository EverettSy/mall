/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsAdminService
 * Author:   YuSong
 * Date:     2019/5/25 15:44
 * Description: 后台管理员Service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.mbg.model.UmsAdmin;
import com.raven.mall.tiny.mbg.model.UmsPermission;
import com.raven.mall.tiny.mbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <<后台管理员Service>>
 *
 * @author Raven
 * @description: 后台管理员Service
 * @date 2019/5/25 15:44
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     *
     * @param username 用户名
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     *
     * @param umsAdminParam  注册参数
     * @return 注册通知
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 刷新token的功能
     *
     * @param oldToken 旧的token
     * @return 生成新的token
     */
    String refreshToken(String oldToken);

    /**
     * 根据用户id获取用户
     *
     * @param id 用户id
     * @return 获取到的用户
     */
    UmsAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param name 用户名
     * @param pageSize 每页数量
     * @param pageNum 页码
     * @return
     */
    List<UmsAdmin> list(String name,Integer pageSize,Integer pageNum);

    /**
     * 修改指定用户信息
     *
     * @param id 用户id
     * @param admin 管理账户
     * @return 信息修改
     */
    int update(Long id,UmsAdmin admin);

    /**
     * 根据id删除指定用户
     *
     * @param id 用户id
     * @return 指定用户被删除
     */
    int delete(Long id);

    /**
     * 修改用户角色关系
     *
     * @param adminId 管理员id
     * @param roleIds 角色关系
     * @return 修改返回
     */
    @Transactional(rollbackFor = Exception.class)
    int updateRole(Long adminId,List<Long> roleIds);


    /**
     * 获取用户对于角色
     *
     * @param adminId 管理员id
     * @return
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 修改用户的+-权限
     *
     * @param adminId
     * @param permissionIds
     * @return
     */
    int updatePermission(Long adminId,List<Long> permissionIds);

    /**
     * 获取用户所有权限(包括 角色权限和+-权限)
     *
     * @param adminId 管理员id
     * @return 获取用户所有权限
     */
    List<UmsPermission> getPermissionList(Long adminId);
}