/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OrderTimeOutCancelTask
 * Author:   YuSong
 * Date:     2019/5/29 15:32
 * Description: 订单超时取消并解锁库存的定时器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <<订单超时取消并解锁库存的定时器>>
 * @Description: 订单超时取消并解锁库存的定时器
 * @author Raven
 * @date 2019/5/29 15:32
 * @version 1.0
 */
@Component
public class OrderTimeOutCancelTask {

    private static final Logger LOGGER  = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每隔 10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        /*CommonResult result = portalOrderService.cancelTimeOutOrder();
        LOGGER.info("取消订单，并根据sku编号释放锁定库存:{}",result);*/
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }
}