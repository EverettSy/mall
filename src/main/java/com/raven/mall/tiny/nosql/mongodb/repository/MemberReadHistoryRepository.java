/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: MemberReadHistoryRepository
 * Author:   YuSong
 * Date:     2019/6/1 15:56
 * Description: 会员商品浏览历史Repository
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.nosql.mongodb.repository;

import com.raven.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * <<会员商品浏览历史Repository>>
 * @Description: 会员商品浏览历史Repository
 * @author Raven
 * @date 2019/6/1 15:56
 * @version 1.0
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {

    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
