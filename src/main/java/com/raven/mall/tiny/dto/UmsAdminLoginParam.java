/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsAdminLoginParam
 * Author:   YuSong
 * Date:     2019/5/27 12:57
 * Description: 用户登录参数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * <<用户登录参数>>
 *
 * @author Raven
 * @Description: 用户登录参数
 * @date 2019/5/27 12:57
 */
@Data
public class UmsAdminLoginParam {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;


}