package com.fidofi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fido on 2017/10/5.
 * 改变字符编码
 */
public class CharsetChangeUtils {
    private static final Logger logger= LoggerFactory.getLogger(CharsetChangeUtils.class);
    public static String getChangeStr(String str){
        String result=null;
         try{
             result=new String(str.getBytes("GBK"),"UTF-8");
         }
         catch (Exception e){
             e.printStackTrace();
             logger.error("字符编码转换出错");
         }
         return  result;
    }

}
