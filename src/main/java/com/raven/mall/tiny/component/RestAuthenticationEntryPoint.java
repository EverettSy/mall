/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: RestAuthenticationEntryPoint
 * Author:   YuSong
 * Date:     2019/5/27 14:39
 * Description: 当未登录或token失效时，返回JSON格式的结果；
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.component;

import cn.hutool.json.JSONUtil;
import com.raven.mall.tiny.common.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <<功能简述>> 
 * @Description: 当未登录或token失效时，返回JSON格式的结果；
 * @author Raven
 * @date 2019/5/27 14:39
 * @version 1.0
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(e.getMessage())));
    response.getWriter().flush();
    }
}