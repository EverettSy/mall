/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OssController
 * Author:   YuSong
 * Date:     2019/6/5 13:46
 * Description: Oss相关操作接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.controller;

import com.raven.mall.tiny.common.api.CommonResult;
import com.raven.mall.tiny.dto.OssCallbackResult;
import com.raven.mall.tiny.dto.OssPolicyResult;
import com.raven.mall.tiny.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <<Oss相关操作接口Controller>>
 * @Description: Oss相关操作接口
 * @author Raven
 * @date 2019/6/5 13:46
 * @version 1.0
 */
@Controller
@Api(tags = "OssController",description = "OSS管理")
@RequestMapping("/aliyun/oss")
public class OssController {

    @Autowired
    private OssServiceImpl ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult> policy(){
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "callback",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request){
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }
}