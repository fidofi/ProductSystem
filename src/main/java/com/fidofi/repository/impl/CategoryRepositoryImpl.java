package com.fidofi.repository.impl;

import com.fidofi.model.CategoryAndCount;
import com.fidofi.repository.CategoryRepository;
import com.fidofi.utils.DB.impl.BeanListHandler;
import com.fidofi.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2017/10/14.
 */
public class CategoryRepositoryImpl implements CategoryRepository {

    /**
     * 根据类别查询该类别下的所有商品的初始上架量之和以及库存，计算该类别的总销量
     * @return
     */
    public List<CategoryAndCount> getAllCategoryAndCount() {
        String sql = "select categoryCode ,SUM(originStock) as 'originStock' , SUM(productStock) as 'productStock' FROM product GROUP BY categoryCode";
        Object[] args = {};
        List<CategoryAndCount> categoryAndCountList = (List<CategoryAndCount>)
                DBUtils.select(new BeanListHandler(CategoryAndCount.class), sql, args);
        return categoryAndCountList;
    }
}
