/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: EsProductRepository
 * Author:   YuSong
 * Date:     2019/5/30 17:41
 * Description: 商品ES操作
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.nosql.elasticsearch.repository;

import com.raven.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * <<商品ES操作类>>
 * @Description: 商品ES操作类
 * @author Raven
 * @date 2019/5/30 17:41
 * @version 1.0
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {

    /**
     * 搜索查询
     *
     * @param name          商品名称
     * @param subTitle      商品标题
     * @param keywords      商品关键字
     * @param page          分页信息
     * @return
     */

    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);

}