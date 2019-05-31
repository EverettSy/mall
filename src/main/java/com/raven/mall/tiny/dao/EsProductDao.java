/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: EsProductDao
 * Author:   YuSong
 * Date:     2019/5/30 19:04
 * Description: 搜索系统中的商品管理自定义Dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dao;

import com.raven.mall.tiny.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <<搜索系统中的商品管理自定义Dao>>
 *
 * @author Raven
 * @version 1.0
 * @Description: 搜索系统中的商品管理自定义Dao
 * @date 2019/5/30 19:04
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
