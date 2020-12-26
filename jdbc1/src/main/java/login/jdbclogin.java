package login;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description 模拟登录
 * @Author MR
 * @Date 2020/12/22 14:26
 */
public class jdbclogin {
    public static void main(String[] args) throws IOException, SQLException {
        Map<String,String> userLoginInfo = initUI();
        System.out.println(login(userLoginInfo)?"登录成功":"登录失败");
    }

    private static boolean login(Map<String,String> userLoginInfo) throws IOException, SQLException {
        // JDBC连接数据库

        // 读取配置文件
        InputStream in = jdbclogin.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        String JDBC_URL = properties.getProperty("JDBC_URL");
        String JDBC_USER = properties.getProperty("JDBC_USER");
        String JDBC_PASSWORD = properties.getProperty("JDBC_PASSWORD");
        String Driver = properties.getProperty("Driver");

        // 注册驱动 利用反射加载静态方法块注册
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }

        // 获取连接对象
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        // 需要执行的sql语句
        String sql = "SELECT * FROM t_user WHERE username=? AND userpwd=?";
        // 获取可执行sql的对象（避免注入攻击）
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        // 设置参数
        preparedStatement.setObject(1, userLoginInfo.get("loginName"));
        preparedStatement.setObject(2, userLoginInfo.get("loginPwd"));
        // 执行
        ResultSet rs = preparedStatement.executeQuery();
        return rs.next();
    }

    private static Map<String,String> initUI() {
        // 读取用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名：");
        String loginName = sc.nextLine();
        System.out.println("密码：");
        String loginPwd = sc.nextLine();

        // 构造hashMap
        Map<String,String> userLoginInfo = new HashMap<String, String>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        // 返回数据
        return userLoginInfo;
    }
}
