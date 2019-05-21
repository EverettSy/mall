/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsMemberController
 * Author:   YuSong
 * Date:     2019/5/21 18:52
 * Description: 会员登录注册管理Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.controller;

import com.raven.mall.tiny.common.api.CommonResult;
import com.raven.mall.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <<会员登录注册管理 Controller>>
 *
 * @author Raven
 * @description: 会员登录注册管理Controller
 * @date 2019/5/21 18:52
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return memberService.verifyAuthCode(telephone, authCode);
    }
}