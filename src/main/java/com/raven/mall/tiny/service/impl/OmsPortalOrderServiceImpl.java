/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OmsPortalOrderServiceImpl
 * Author:   YuSong
 * Date:     2019/6/2 23:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service.impl;

import com.raven.mall.tiny.common.api.CommonResult;
import com.raven.mall.tiny.component.CancelOrderSender;
import com.raven.mall.tiny.dto.OrderParam;
import com.raven.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <<前台订单管理Service实现类>>
 * @Description:
 * @author Raven
 * @date 2019/6/2 23:06
 * @version 1.0
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        /*List<omsor>*/
        LOGGER.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null,"下单成功");
    }

    @Override
    public void cancelOrder(long orderId) {
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(long orderId) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 30 * 1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(orderId,delayTimes);
    }

}