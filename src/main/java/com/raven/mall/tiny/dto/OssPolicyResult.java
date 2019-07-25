/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OssPolicyResult
 * Author:   YuSong
 * Date:     2019/6/5 12:17
 * Description: 获取OSS上传文件授权返回结果
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <<获取OSS上传文件授权返回结果>>
 * @Description: 获取OSS上传文件授权返回结果,前端直接上传文件时所需参数，从后端返回过来。
 * @author Raven
 * @date 2019/6/5 12:17
 * @version 1.0
 */
@Data
public class OssPolicyResult {

    @ApiModelProperty("访问身份验证中用到用户识别")
    private String accessKeyId;

    @ApiModelProperty("用户表单上传的策略,经过base64编码过的字符串")
    private String policy;

    @ApiModelProperty("对policy签名后的字符串")
    private String signature;

    @ApiModelProperty("上传文件夹路径前缀")
    private String dir;

    @ApiModelProperty("oss对外服务的访问域名")
    private String host;

    @ApiModelProperty("上传成功后的回调设置")
    private String callback;
}