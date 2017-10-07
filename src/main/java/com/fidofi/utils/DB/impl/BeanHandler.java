package com.fidofi.utils.DB.impl;

import com.fidofi.enums.ResultEnums;
import com.fidofi.exception.GetBeanException;
import com.fidofi.utils.DB.ResultHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by fido on 2017/10/1.
 * 将查询结果封装成一个对象
 */
public class BeanHandler implements ResultHandler {
    private static final Logger logger = LoggerFactory.getLogger(BeanHandler.class);
    private Class clazz;//表示封装的bean类，用反射来获取信息

    public BeanHandler(Class clazz) {
        this.clazz = clazz;
    }

    public Object handler(ResultSet rs) {
        try {
            if (!rs.next()) {
                return null;
            }
            Object bean = clazz.newInstance(); //通过反射创建Bean对象
            ResultSetMetaData rsmt = rs.getMetaData();//获得结果集的元数据
            int columnNum = rsmt.getColumnCount();//获得共有多少列（即多少个属性）
            for (int i = 0; i < columnNum; i++) {
                String columnName = rsmt.getColumnName(i + 1);//得到每列的列名
                Object columnData = rs.getObject(i + 1);//得到数据

                Field field = clazz.getDeclaredField(columnName);//通过反射，获得类的对应属性
                field.setAccessible(true);
                field.set(bean, columnData); //然后设置相应的属性的值
            }
            return bean;

        } catch (Exception e) {
            throw new GetBeanException(ResultEnums.PRODUCT_NOT_EXIST);

        }
    }
}
