/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OssCallbackParam
 * Author:   YuSong
 * Date:     2019/6/5 12:28
 * Description: oss上传成功后的回调参数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <<oss上传成功后的回调参数>>
 * @Description: oss上传成功后的回调参数,
 * 当OSS上传成功后，会根据该配置参数来回调对应接口。
 * @author Raven
 * @date 2019/6/5 12:28
 * @version 1.0
 */
@Data
public class OssCallbackParam {

    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;
    @ApiModelProperty("回调时传入request中的参数")
    private String callbackBody;
    @ApiModelProperty("回调时传入参数的格式,比如表单提交形式")
    private String callbackBodyType;
}