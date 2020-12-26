package jdbcbasis;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * @version 1.0
 * @Description 连接mysqldemo,使用Batch。
 * @Author MR
 * @Date 2020/12/21 21:02
 */

/*
第一步:注册驱动(作用:告诉Java程序，即将要连接的是哪个品牌的数据库)
第二步:获取连接(表示JVM的进程和数据库进程之间的通道打开了，使用完必须关闭)
第三步:获取数据库操作对象(专门执行sql语句的对象)
第四步:执行sQL语句(DQL DML....)
第五步:处理香询结果集(只有当第四步执行的是select语句的时才有这一步)
第六步:释放资源(使用完资源之后一定要关闭资源)
资源释放顺序：(ResultSet结果集)=>数据库操作对象(PreparedStatement/Statement)=>数据库连接对象(Connection)
 */

public class Main {
    // 数据库连接地址
    private static String JDBC_URL = null;
    // 用户名
    private static String JDBC_USER = null;
    // 密码
    private static String JDBC_PASSWORD = null;
    // 驱动
    private static String Driver = null;
    // 储存学生信息
    private static final List<Student> students = new ArrayList<Student>();

    public static void main(String[] args) throws SQLException, IOException {
        // 读取配置文件
        InputStream in = Main.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(in);
        JDBC_URL = properties.getProperty("JDBC_URL");
        JDBC_USER = properties.getProperty("JDBC_USER");
        JDBC_PASSWORD = properties.getProperty("JDBC_PASSWORD");
        Driver = properties.getProperty("Driver");

        // 注册驱动 利用反射加载静态方法块注册
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }

        // 获取连接对象
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 需要执行的sql语句
            String sql = "SELECT * FROM student WHERE sdept=?";
            // 获取可执行sql的对象（避免注入攻击）
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                // 设置参数
                preparedStatement.setObject(1, "软件工程");
                // 执行
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    /**
                     * 执行查询 .executeQuery() 查
                     * 返回值 ResultSet结果集
                     * 执行更新 .executeUpdate() 增 删 改
                     * 返回值 int（更新数量）
                     */
                    //遍历结果集，取出数据（.next()返回布尔值）
                    while (rs.next()) {
                        Student student = new Student();
                        student.setSno(rs.getString("Sno"));
                        student.setSname(rs.getString("Sname"));
                        student.setSsex(rs.getString("Ssex"));
                        student.setSage(rs.getInt("Sage"));
                        student.setSdept(rs.getString("Sdept"));
                        students.add(student);
                    }
                }
            }
        }

        // 输出结果
        students.forEach(System.out::println);
//        useBatch(students);
    }
    // 只有参数不同的若干语句可以作为batch执行
    public static void useBatch(List<Student> list) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO student  VALUES (?, ?, ?, ?, ?)")) {
                // 对同一个PreparedStatement反复设置参数并调用addBatch():
                for (Student s : list) {
                    ps.setString(1, s.getSno() + 1);
                    ps.setString(2, s.getSname());
                    ps.setString(3, s.getSsex());
                    ps.setInt(4, s.getSage());
                    ps.setString(5, s.getSdept());
                    // 添加到batch
                    ps.addBatch();
                }
                // 执行batch:
                int[] ns = ps.executeBatch();
                for (int n : ns) {
                    // batch中每个SQL执行的结果数量
                    System.out.println(n + " inserted.");
                }
            }
        }
    }
}
