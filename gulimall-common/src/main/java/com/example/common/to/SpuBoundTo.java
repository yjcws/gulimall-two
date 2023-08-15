package com.example.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: yjc
 * @createTime: 2020-06-01 08:45
 **/

@Data
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
