/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OssService
 * Author:   YuSong
 * Date:     2019/6/5 12:38
 * Description: oss上传管理Service
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.dto.OssCallbackResult;
import com.raven.mall.tiny.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * <<oss上传管理Service>>
 * @Description: oss上传管理Service
 * @author Raven
 * @date 2019/6/5 12:38
 * @version 1.0
 */
public interface OssService {

    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     * @param request 回调参数
     */
    OssCallbackResult callback(HttpServletRequest request);
}
