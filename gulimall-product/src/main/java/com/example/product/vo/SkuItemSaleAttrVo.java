package com.example.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description:
 * @Author: yjc
 * @createTime: 2020-06-19 18:17
 **/

@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;
//    AttrValueWithSkuIdVO
    private List<AttrValueWithSkuIdVO> attrValues;

}
