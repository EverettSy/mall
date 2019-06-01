/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: MemberReadHistoryController
 * Author:   YuSong
 * Date:     2019/6/1 17:04
 * Description: 会员商品浏览记录管理Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.controller;

import com.raven.mall.tiny.common.api.CommonResult;
import com.raven.mall.tiny.nosql.mongodb.document.MemberReadHistory;
import com.raven.mall.tiny.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <<功能简述>> 
 * @Description: 会员商品浏览记录管理Controller
 * @author Raven
 * @date 2019/6/1 17:04
 * @version 1.0
 */
@Controller
@Api(tags = "MemberReadHistoryController",description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量删除浏览记录")
    @RequestMapping(value = "/detele",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult detele(@RequestParam("ids")List<String> ids){
        int count = memberReadHistoryService.delete(ids);
        if (count > 0){
           return CommonResult.success(count);
        }else {
             return CommonResult.failed();
        }
    }

    @ApiOperation("展示浏览记录")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberReadHistory>> list(Long memberId){
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return CommonResult.success(memberReadHistoryList);
    }
}