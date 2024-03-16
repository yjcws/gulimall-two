package com.example.gulimallsearch.service;



import com.example.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Author: yjc
 * @createTime: 2020-06-06 16:53
 **/
public interface ProductSaveService {

    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
