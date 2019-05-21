/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsMemberServiceImpl
 * Author:   YuSong
 * Date:     2019/5/21 18:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service.impl;

import com.raven.mall.tiny.common.api.CommonResult;
import com.raven.mall.tiny.service.RedisService;
import com.raven.mall.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * <<会员管理Service实现类>>
 *
 * @author Raven
 * @description: 会员管理Service实现类
 * @date 2019/5/21 18:59
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 生成验证码
     * @param telephone 手机号码
     * @return
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        //随机生成6位数验证码
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并 存储到 redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }


    /**
     * 对输入的验证码进行校验
     * @param telephone 手机号码
     * @param authCode 验证码
     * @return
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        //对比输入的验证码与Redis中的是否相同
        boolean result = authCode.equals(realAuthCode);
        if (result){
            return CommonResult.success(null,"验证码校验成功");
        }else{
            return CommonResult.failed("验证码不正确");
        }
    }
}