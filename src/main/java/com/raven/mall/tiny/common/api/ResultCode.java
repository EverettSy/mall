/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: ResultCode
 * Author:   YuSong
 * Date:     2019/5/17 18:28
 * Description: 枚举了一些常用API操作码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.common.api;


/**
 * <<枚举了一些常用API操作码>>
 *
 * @author Raven
 * @description: 枚举了一些常用API操作码
 * @date 2019/5/17 18:28
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILED(404,"参数校验失败"),
    UNAUTHORIZED(401,"暂未登录或token已经过期"),
    FORBIDDEN(403,"没有相关权限");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
