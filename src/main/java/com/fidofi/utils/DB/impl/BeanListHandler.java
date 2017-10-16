package com.fidofi.utils.DB.impl;

import com.fidofi.enums.ResultEnums;
import com.fidofi.exception.GetListException;
import com.fidofi.utils.DB.ResultHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2017/10/1.
 * 将查询结果封装成集合
 */
public class BeanListHandler implements ResultHandler {
    private Class clazz;//集合里装载对象的类型
    public BeanListHandler(Class clazz) {
     this.clazz=clazz;
    }

    public Object handler(ResultSet rs) {
        try {
            if(!rs.next()){
                return null;
            };
            //结果集的游标要摆回第一个之前
            rs.beforeFirst();
            List list=new ArrayList<Object>();
            while(rs.next()){
                Object bean=clazz.newInstance();
                ResultSetMetaData rmt=rs.getMetaData(); //获得结果集的元数据
                int columnNum=rmt.getColumnCount();
                for(int i=0;i<columnNum;i++){
                    String columnName=rmt.getColumnName(i+1);
                    Object columnData=rs.getObject(i+1);
                    Field field=bean.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(bean, columnData);
                }
                list.add(bean);
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new GetListException(ResultEnums.LIST_NOT_EXIST);
        }
    }
}
