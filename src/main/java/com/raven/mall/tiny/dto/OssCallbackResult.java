/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OssCallbackResult
 * Author:   YuSong
 * Date:     2019/6/5 12:34
 * Description: oss上传文件的回调结果
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <<oss上传文件的回调结果>>
 * @Description: oss上传文件的回调结果
 *
 * 回调接口中返回的数据对象，封装了上传文件的信息。
 * @author Raven
 * @date 2019/6/5 12:34
 * @version 1.0
 */
@Data
public class OssCallbackResult {

    @ApiModelProperty("文件名称")
    private String filename;
    @ApiModelProperty("文件大小")
    private String size;
    @ApiModelProperty("文件的mimeType")
    private String mimeType;
    @ApiModelProperty("图片文件的宽")
    private String width;
    @ApiModelProperty("图片文件的高")
    private String height;
}