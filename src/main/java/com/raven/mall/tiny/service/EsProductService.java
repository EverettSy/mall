/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: EsProductService
 * Author:   YuSong
 * Date:     2019/5/30 18:42
 * Description: 商品搜索管理Service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <<功能简述>> 
 * @Description: 商品搜索管理Service
 * @author Raven
 * @date 2019/5/30 18:42
 * @version 1.0
 */
public interface EsProductService {

    /**
     * 从数据库中导入所有商品到ES
     * @return
     */
    int importAll();

    /**
     * 根据ID删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据ID创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     * @param keyword 关键字
     * @param pageNum 页数
     * @param pageSize 数量
     * @return
     */
    Page<EsProduct> search(String keyword,Integer pageNum,Integer pageSize);
}