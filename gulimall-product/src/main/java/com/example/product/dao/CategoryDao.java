package com.example.product.dao;

import com.example.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2023-04-04 00:18:16
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
