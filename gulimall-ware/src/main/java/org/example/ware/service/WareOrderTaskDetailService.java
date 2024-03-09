package org.example.ware.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import org.example.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @Author: yjc
 * @date 2020-05-22 19:55:33
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

