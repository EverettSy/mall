/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: MemberReadHistoryService
 * Author:   YuSong
 * Date:     2019/6/1 16:43
 * Description: 会员浏览记录管理Service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * <<会员浏览记录管理Service>>
 * @Description: 会员浏览记录管理Service
 * @author Raven
 * @date 2019/6/1 16:43
 * @version 1.0
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids 记录集合
     * @return
     */
    int delete(List<String> ids);

    /**
     * 根据会员id获取用户浏览历史记录
     * @param memberId 会员id
     * @return 浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}