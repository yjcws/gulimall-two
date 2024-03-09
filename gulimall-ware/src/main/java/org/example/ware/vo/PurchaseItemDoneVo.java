package org.example.ware.vo;

import lombok.Data;

/**
 * @Description:
 * @Author: yjc
 * @createTime: 2020-06-01 20:34
 **/

@Data
public class PurchaseItemDoneVo {

    private Long itemId;

    private Integer status;

    private String reason;

}
