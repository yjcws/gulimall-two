package com.example.product.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.product.entity.ProductAttrValueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu属性值
 * 
 * @Author: yjc
 * @date 2020-05-22 19:00:18
 */
@Mapper
public interface ProductAttrValueDao extends BaseMapper<ProductAttrValueEntity> {
	
}
