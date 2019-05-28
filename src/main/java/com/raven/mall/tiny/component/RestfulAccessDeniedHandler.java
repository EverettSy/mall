/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: RestfulAccessDeniedHandler
 * Author:   YuSong
 * Date:     2019/5/27 14:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.component;

import cn.hutool.json.JSONUtil;
import com.raven.mall.tiny.common.api.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <<当访问接口没有权限时，自定义的返回结果>>
 *
 * @author Raven
 * @version 1.0
 * @description:当用户没有访问权限时的处理器，用于返回JSON格式的处理结果；
 * @date 2019/5/27 14:03
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.getWriter().println(JSONUtil.parse(CommonResult.forbidden(e.getMessage())));
    response.getWriter().flush();
    }
}