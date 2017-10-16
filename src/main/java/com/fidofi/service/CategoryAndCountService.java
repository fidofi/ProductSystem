package com.fidofi.service;

import com.fidofi.model.CategoryAndCount;
import com.fidofi.vo.CategoryAndCountVO;

import java.util.List;

/**
 * Created by fido on 2017/10/14.
 */
public interface CategoryAndCountService {
    public List<CategoryAndCountVO>  getAllCategoryAndCount();
}
