/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: PmsBrandServiceImpl
 * Author:   YuSong
 * Date:     2019/5/17 17:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.raven.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.raven.mall.tiny.mbg.model.PmsBrand;
import com.raven.mall.tiny.mbg.model.PmsBrandExample;
import com.raven.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <<PmsBrandService实现类>>
 * @description: PmsBrandService实现类
 * @author Raven
 * @date 2019/5/17 17:28
 * @version
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        brandMapper.selectByExample(new PmsBrandExample());
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}