/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: OssConfig
 * Author:   YuSong
 * Date:     2019/6/5 11:31
 * Description: 用于配置OSS的连接客户端OSSClient。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <<客户端OSSClient>>
 *
 * @author Raven
 * @version 1.0
 * @Description: 用于配置OSS的连接客户端OSSClient。
 * @date 2019/6/5 11:31
 */
@Configuration
public class OssConfig {

    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;
    @Value("${aliyun.oss.accessKeyId}")
    private String ALIYUN_OSS_ACCESSKEYID;
    @Value("${aliyun.oss.accessKeySecret}")
    private String ALIYUN_OSS_ACCESSKEYSECRET;

    @Bean
    public OSSClient ossClient() {
        return new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
    }
}