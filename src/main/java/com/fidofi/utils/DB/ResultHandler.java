package com.fidofi.utils.DB;

import java.sql.ResultSet;

/**
 * Created by fido on 2017/10/1.
 * jdbc的查询封装接口
 */
public interface ResultHandler {
    /**
     * 将结果集封装成调用端所需要的信息
     * @param rs
     * @return
     */
    public Object handler(ResultSet rs);
}
