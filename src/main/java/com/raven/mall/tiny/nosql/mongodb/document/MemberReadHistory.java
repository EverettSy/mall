/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: MemberReadHistory
 * Author:   YuSong
 * Date:     2019/6/1 16:35
 * Description: 会员商品浏览历史记录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.nosql.mongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * <<会员商品浏览历史记录>>
 * @Description: 会员商品浏览历史记录
 * @author Raven
 * @date 2019/6/1 16:35
 * @version 1.0
 */
@Document
@Data
public class MemberReadHistory {

    /**
     *  * @Document: 标示映射到Mongodb文档上的领域对象
     *  * @Id:  标示某个域为ID域
     *  * @Indexed: 标示某个字段为Mongodb的索引字段
     *  * @author Raven
     */

    @Id
    private String id;

    @Indexed
    private Long memberId;

    private String memberNickname;
    private String memberIcon;

    @Indexed
    private Long productId;
    private String productName;
    private String productPic;
    private String productSubTitle;
    private String productPrice;
    private Date createTime;
}