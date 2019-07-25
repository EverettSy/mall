/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: WebLog
 * Author:   YuSong
 * Date:     2019/6/30 22:06
 * Description: Controller层的日志封装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import lombok.Data;

/**
 * <<功能简述>> 
 * @Description: Controller层的日志封装类
 * @author Raven
 * @date 2019/6/30 22:06
 * @version 1.0
 */
@Data
public class WebLog {

    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     *操作时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 请求返回的结果
     */
    private Object result;
}