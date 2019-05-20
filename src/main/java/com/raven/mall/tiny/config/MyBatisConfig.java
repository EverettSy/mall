/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: MyBatisConfig
 * Author:   YuSong
 * Date:     2019/5/15 21:56
 * Description: MyBatis配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <<功能简述>> 
 * @description: MyBatis配置类
 * @author Raven
 * @date 2019/5/15 21:56
 * @version
 */
@Configuration
@MapperScan("com.raven.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}