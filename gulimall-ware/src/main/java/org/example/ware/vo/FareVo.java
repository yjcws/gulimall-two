package org.example.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: yjc
 * @createTime: 2020-07-03 20:07
 **/

@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}


