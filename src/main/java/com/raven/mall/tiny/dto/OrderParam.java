/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OrderParam
 * Author:   YuSong
 * Date:     2019/6/3 18:04
 * Description: 生成订单时传入的参数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import lombok.Data;

/**
 * <<生成订单时传入的参数>>
 * @Description: 生成订单时传入的参数
 * @author Raven
 * @date 2019/6/3 18:04
 * @version 1.0
 */
@Data
public class OrderParam {

    //收获地址id
    private Long memberReceiveAddressId;

    //优惠券id
    private Long couponId;

    //使用的积分数
    private Integer useIntegration;

    //支付方式
    private Integer payType;
}