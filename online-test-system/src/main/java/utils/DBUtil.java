package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @version 1.0
 * @Description JDBC封装工具类
 * @Author MR
 * @Date 2020/12/22 15:29
 */
public class DBUtil {
    // 数据库连接地址
    private static String JDBC_URL = null;
    // 用户名
    private static String JDBC_USER = null;
    // 密码
    private static String JDBC_PASSWORD = null;
    // 驱动
    private static String Driver = null;

    // 构造方法
    public DBUtil() {
    }

    // 静态代码块，只在类加载的时候执行一次。
    static {
        // 读取配置文件
        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JDBC_URL = properties.getProperty("JDBC_URL");
        JDBC_USER = properties.getProperty("JDBC_USER");
        JDBC_PASSWORD = properties.getProperty("JDBC_PASSWORD");
        Driver = properties.getProperty("Driver");
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接对象
     * @throws  SQLException
     * @return 连接对象
     */
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    /**
     * 关闭资源
     * @param connection 数据库连接对象
     * @param statement 数据库操作对象
     * @param resultSet 数据库查询结果集
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
