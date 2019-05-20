/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: CommonPage
 * Author:   YuSong
 * Date:     2019/5/17 20:54
 * Description: 分页数据封装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.common.api;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * <<分页数据封装类>>
 *
 * @author Raven
 * @description: 分页数据封装类
 * @date 2019/5/17 20:54
 */
@Data
public class CommonPage<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);

        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
