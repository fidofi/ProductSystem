package com.fidofi.utils;

import java.util.Random;

/**
 * Created by fido on 2017/10/1.
 * 用于生成商品的id
 */
public class KeyUtils {
    public static String getKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return (System.currentTimeMillis() + String.valueOf(number)).substring(0, 10);
    }
}
