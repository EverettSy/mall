/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: RedisService
 * Author:   YuSong
 * Date:     2019/5/21 16:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

/**
 * <<redis操作Service,>>
 *
 * @author Raven
 * @description: 对象和数组都以json形式进行存储
 * @date 2019/5/21 16:33
 */
public interface RedisService {

    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超期实际
     *
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key, long delta);
}
