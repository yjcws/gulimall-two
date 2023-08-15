package com.example.product.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.product.entity.BrandEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @Author: yjc
 * @date 2020-05-22 19:00:18
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
