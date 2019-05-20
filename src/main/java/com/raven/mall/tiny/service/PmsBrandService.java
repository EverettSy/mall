/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: PmsBrandService
 * Author:   YuSong
 * Date:     2019/5/17 17:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service;

import com.raven.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * <<PmsBrandService接口>> >>
 * @description:
 * @author Raven
 * @date 2019/5/17 17:21
 * @version
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id,PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum,int pageSize);

    PmsBrand getBrand(Long id);
}