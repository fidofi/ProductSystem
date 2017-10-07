package com.fidofi.utils;

import java.util.Random;

/**
 * Created by fido on 2017/10/1.
 * 用于生成商品的条形码
 */
public class BarCodeUtils {
    public static String getBarCode(String key,Integer category){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return category+String.valueOf(number)+key.substring(0,6);
    }
}
