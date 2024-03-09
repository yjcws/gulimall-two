package org.example.ware.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import org.example.ware.entity.WareInfoEntity;
import org.example.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @Author: yjc
 * @date 2020-05-22 19:55:33
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取运费和收货地址信息
     * @param addrId
     * @return
     */
    FareVo getFare(Long addrId);
}

