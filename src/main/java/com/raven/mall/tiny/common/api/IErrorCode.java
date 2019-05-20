/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: IErrorCode
 * Author:   YuSong
 * Date:     2019/5/17 18:26
 * Description: 封装API的错误码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.common.api;

/**
 * <<封装API的错误码>>
 * @description: 封装API的错误码
 * @author Raven
 * @date 2019/5/17 18:26
 * @version
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}