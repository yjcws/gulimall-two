package org.example.ware.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.ware.entity.WareOrderTaskEntity;

/**
 * 库存工作单
 * 
 * @Author: yjc
 * @date 2020-05-22 19:55:33
 */
@Mapper
public interface WareOrderTaskDao extends BaseMapper<WareOrderTaskEntity> {
	
}
