package com.fidofi.service.impl;

import com.fidofi.model.CategoryAndCount;
import com.fidofi.repository.CategoryRepository;
import com.fidofi.repository.impl.CategoryRepositoryImpl;
import com.fidofi.service.CategoryAndCountService;
import com.fidofi.utils.CategoryCodeUtils;
import com.fidofi.vo.CategoryAndCountVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by fido on 2017/10/14.
 */
public class CategoryAndCountServiceImpl implements CategoryAndCountService {
    private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    /**
     * mysql的sum函数返回的是BigDecimal类型的，故这里需要转换成VO对象
     * @return
     */
    public List<CategoryAndCountVO> getAllCategoryAndCount() {
        List<CategoryAndCount> list=categoryRepository.getAllCategoryAndCount();
        List<CategoryAndCountVO> categoryAndCountVOS=new ArrayList<CategoryAndCountVO>();
        for(CategoryAndCount categoryAndCount:list){
            CategoryAndCountVO categoryAndCountVO=new CategoryAndCountVO();
            categoryAndCountVO.setCategoryCode(CategoryCodeUtils.getStr(categoryAndCount.getCategoryCode()));
            categoryAndCountVO.setOriginStock(categoryAndCount.getOriginStock().intValue());
            categoryAndCountVO.setProductStock(categoryAndCount.getProductStock().intValue());
            categoryAndCountVO.setSell(categoryAndCount.getOriginStock().intValue()-categoryAndCount.getProductStock().intValue());
            categoryAndCountVOS.add(categoryAndCountVO);
        }
        return categoryAndCountVOS;
    }
}
