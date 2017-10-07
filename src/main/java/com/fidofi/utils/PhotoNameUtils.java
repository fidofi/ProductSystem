package com.fidofi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by fido on 2017/10/5.
 * 生成图片名字
 */
public class PhotoNameUtils {
    public static String getPhotoName(){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        String time=format.format(new Date());
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return time+number;
    }
}
