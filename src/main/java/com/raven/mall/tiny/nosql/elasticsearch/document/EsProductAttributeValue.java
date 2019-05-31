/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: EsProductAttributeValue
 * Author:   YuSong
 * Date:     2019/5/29 17:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * <<功能简述>> 
 * @Description:
 * @author Raven
 * @date 2019/5/29 17:37
 * @version 1.0
 */
@Data
public class EsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = -2666179928977796573L;

    private long id;
    private Long productAttributeId;
    //属性值
    @Field(type = FieldType.Keyword)
    private String value;
    //属性参数：0->规格； 1->参数
    private Integer type;
    //属性名称
    @Field(type = FieldType.Keyword)
    private String name;


}