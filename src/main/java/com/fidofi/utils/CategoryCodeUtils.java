package com.fidofi.utils;

import com.fidofi.enums.CategoryEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2017/10/3.
 * 类别的名称和对应的状态码转换
 */
public class CategoryCodeUtils {
    public static Integer getCode(String categoryName) {
        CategoryEnum[] categoryEnums = CategoryEnum.values();
        Integer result = null;
        for (int i = 0; i < categoryEnums.length; i++) {
            if (categoryEnums[i].getCategoryName().equals(categoryName)) {
                result = categoryEnums[i].getCode();
                break;
            }
        }
        return result;
    }

    public static String getStr(Integer categoryCode) {
        CategoryEnum[] categoryEnums = CategoryEnum.values();
        String result = null;
        for (int i = 0; i < categoryEnums.length; i++) {
            //TODO
            //这里原本用==来比较，不行，后面改用equal来判断，可以了，为啥
            if (categoryEnums[i].getCode().equals(categoryCode)) {
                result = categoryEnums[i].getCategoryName();
                break;
            }
        }
        return result;
    }

    public static List<String> categoryName() {
        CategoryEnum[] categoryEnums = CategoryEnum.values();
        List<String> categoryNameList = new ArrayList<String>();
        for (int i = 0; i < categoryEnums.length; i++) {
            categoryNameList.add(categoryEnums[i].getCategoryName());
        }
        return categoryNameList;
    }
}
