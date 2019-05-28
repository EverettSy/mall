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
     * 获取用户所有权限(包括 角色权限和+-权限)
     *
     * @param adminId 管理员id
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}