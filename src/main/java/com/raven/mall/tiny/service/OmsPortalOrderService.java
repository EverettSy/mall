/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OmsPortalOrderService
 * Author:   YuSong
 * Date:     2019/6/2 23:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.common.api.CommonResult;
import com.raven.mall.tiny.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * <<前台订单管理Service>>
 * @Description: 前台订单管理Service
 * @author Raven
 * @date 2019/6/2 23:01
 * @version 1.0
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     * @param orderParam 订单参数
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(long orderId);

}