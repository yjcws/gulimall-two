package com.example.product.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.product.entity.SkuInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku信息
 * 
 * @Author: yjc
 * @date 2020-05-22 19:00:18
 */
@Mapper
public interface SkuInfoDao extends BaseMapper<SkuInfoEntity> {
	
}
