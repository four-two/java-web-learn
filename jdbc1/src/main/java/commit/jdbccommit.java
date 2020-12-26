package commit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @version 1.0
 * @Description jdbc事务
 * @Author MR
 * @Date 2020/12/22 14:50
 */
public class jdbccommit {
    public static void main(String[] args) throws IOException, SQLException {
        // 读取配置文件
        InputStream in = jdbccommit.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
        try {
            // 关闭自动提交:
            conn.setAutoCommit(false);
            // 执行多条SQL语句:
            String updateSql = "UPDATE t_act SET menoy=? WHERE actno=? ";
            // 获取可执行sql的对象（避免注入攻击）
            PreparedStatement ps = conn.prepareStatement(updateSql);
            // 设置参数并执行
            ps.setDouble(1, 10000);
            ps.setInt(2, 111);
            int n = ps.executeUpdate();

            ps.setDouble(1, 10000);
            ps.setInt(2, 222);
            n += ps.executeUpdate();
            // 提交事务:
            conn.commit();
            System.out.println(n == 2 ? "转账成功" : "转账失败");
        } catch (SQLException e) {
            // 回滚事务:
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}
