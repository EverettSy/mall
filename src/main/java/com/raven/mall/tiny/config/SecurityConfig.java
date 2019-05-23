/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: SecurityConfig
 * Author:   YuSong
 * Date:     2019/5/24 0:38
 * Description: SpringSecurity的配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <<功能简述>> 
 * @description: SpringSecurity的配置
 * @author Raven
 * @date 2019/5/24 0:38
 * @version
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    
}