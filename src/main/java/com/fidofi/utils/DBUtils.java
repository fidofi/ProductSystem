package com.fidofi.utils;

import com.fidofi.model.Product;
import com.fidofi.utils.DB.ResultHandler;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by fido on 2017/9/30.
 * jdbc相关的工具类
 */
public class DBUtils {

    //日志记录
    private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);
    //数据库连接池
    private static ComboPooledDataSource datasource = null;

    static {
        datasource = new ComboPooledDataSource("mysql_fido");
        //会自动去读取c3p0.properties配置文件
    }

    /**
     * 获得连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param ps
     * @param rs
     */
    public static void release(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (conn != null) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            conn = null;
                        }
                    }
                    ps = null;
                }
            }
            rs = null;
        }
    }

    /**
     * 增删改操作的封装
     *
     * @param sql
     * @param args
     * @return
     */
    public static void update(String sql, Object[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("增删改操作出现异常");
        } finally {
            DBUtils.release(conn, ps, rs);
        }
    }

    /**
     * 查询操作
     * @param rst
     * @param sql
     * @param args
     * @return
     */

    public static Object select(ResultHandler rst, String sql, Object[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object object = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();
            object = rst.handler(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询操作出现异常");
        } finally {
            DBUtils.release(conn, ps, rs);
        }
        return object;
    }

}
