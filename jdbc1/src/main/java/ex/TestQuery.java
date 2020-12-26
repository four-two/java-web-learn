package ex;

import jdbcbasis.Student;
import utils.DBUtil;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * @version 1.0
 * @Description 调用封装类进行模糊查询
 * @Author MR
 * @Date 2020/12/22 15:49
 */
public class TestQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 获取连接对象
            connection = DBUtil.getconnection();
            String sql = "SELECT * FROM student WHERE sdept LIKE ?";
            try {
                // 获取数据库操作对象
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setObject(1, "%工程");
                // 执行获取结果集
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setSno(resultSet.getString("Sno"));
                    student.setSname(resultSet.getString("Sname"));
                    student.setSsex(resultSet.getString("Ssex"));
                    student.setSage(resultSet.getInt("Sage"));
                    student.setSdept(resultSet.getString("Sdept"));
                    System.out.println(student.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
    }
}
