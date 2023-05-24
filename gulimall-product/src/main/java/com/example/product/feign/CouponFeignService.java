package com.example.product.feign;

import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: CouponFeignService
 * @Description:
 * @Author: yjc
 * @Date: 2023/4/5 11:23
 */
@Component
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/test")
    public R test();
}
