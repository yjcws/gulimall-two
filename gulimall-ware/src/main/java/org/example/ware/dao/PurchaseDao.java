package org.example.ware.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.ware.entity.PurchaseEntity;

/**
 * 采购信息
 * 
 * @Author: yjc
 * @date 2020-05-22 19:55:33
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
