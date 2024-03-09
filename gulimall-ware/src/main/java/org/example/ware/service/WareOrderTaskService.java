package org.example.ware.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import org.example.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @Author: yjc
 * @date 2020-05-22 19:55:33
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);

    WareOrderTaskEntity getOrderTaskByOrderSn(String orderSn);
}

