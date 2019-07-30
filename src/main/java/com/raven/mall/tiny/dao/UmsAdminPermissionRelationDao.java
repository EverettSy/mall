/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsAdminPermissionRelationDao
 * Author:   YuSong
 * Date:     2019/7/28 19:50
 * Description: 用户权限自定义DAO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dao;

import com.raven.mall.tiny.mbg.model.UmsAdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <<用户权限自定义Dao>>
 * @Description: 用户权限自定义Dao
 * @author Raven
 * @date 2019/7/28 19:50
 * @version 1.0
 */
public interface UmsAdminPermissionRelationDao {
    int insertList(@Param("list")List<UmsAdminPermissionRelation> list);
}
