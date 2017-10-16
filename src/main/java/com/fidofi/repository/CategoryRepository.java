package com.fidofi.repository;

import com.fidofi.enums.CategoryEnum;
import com.fidofi.model.CategoryAndCount;

import java.util.List;

/**
 * Created by fido on 2017/10/14.
 * 用于收集关于类目的数据，图表展示
 */
public interface CategoryRepository {
    public List<CategoryAndCount> getAllCategoryAndCount();
}
