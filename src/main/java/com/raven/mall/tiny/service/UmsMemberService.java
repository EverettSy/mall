/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsMemberService
 * Author:   YuSong
 * Date:     2019/5/21 18:54
 * Description: 会员管理Service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.common.api.CommonResult;

/**
 * <<会员管理Service>>
 * @description: 会员管理Service
 * @author Raven
 * @date 2019/5/21 18:54
 * @version
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone 手机号码
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone 手机号码
     * @param authCode 验证码
     * @return
     */
    CommonResult verifyAuthCode(String telephone,String authCode);
}