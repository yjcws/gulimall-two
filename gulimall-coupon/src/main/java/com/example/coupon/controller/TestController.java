package com.example.coupon.controller;

import com.example.common.utils.R;
import com.example.coupon.entity.CouponEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: yjc
 * @Date: 2023/4/5 11:24
 */
@RestController
@RequestMapping("/coupon")
@RefreshScope
public class TestController {

    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private String age;


//    @Transactional
    @RequestMapping("/test")
    public R test(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setAge(age);
        couponEntity.setName(name);
        couponEntity.setCreateTime(new Date());

        Date time = new Date();
        return R.ok().put("test",couponEntity);
    }

}
