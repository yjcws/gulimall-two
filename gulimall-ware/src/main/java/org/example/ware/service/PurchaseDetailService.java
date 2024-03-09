package org.example.ware.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import org.example.ware.entity.PurchaseDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @Author: yjc
 * @date 2020-05-22 19:55:33
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PurchaseDetailEntity> listDetailByPurchaseId(Long id);
}

