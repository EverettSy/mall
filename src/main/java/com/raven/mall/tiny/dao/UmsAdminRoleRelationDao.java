/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsAdminRoleRelationDao
 * Author:   YuSong
 * Date:     2019/5/25 18:57
 * Description: 后台用户与角色管理自定义Dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dao;

import com.raven.mall.tiny.mbg.model.UmsAdminRoleRelation;
import com.raven.mall.tiny.mbg.model.UmsPermission;
import com.raven.mall.tiny.mbg.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <<后台用户与角色管理自定义Dao>>
 *
 * @author Raven
 * @version 1.0
 * @Description: 后台用户与角色管理自定义Dao
 * @date 2019/5/25 18:57
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 批量插入用户角色关系
     *
     * @param adminRoleRelationList
     * @return
     */
    int insertList(@Param("list")List<UmsAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     *
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有角色权限
     *
     * @param adminId
     * @return
     */
    List<UmsPermission> getRolePermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有权限(包括+-权限)
     *
     * @param adminId 管理员id
     * @return 用户所有权限
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
