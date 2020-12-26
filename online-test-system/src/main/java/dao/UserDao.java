package dao;

import entity.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/24 13:28
 */
public class UserDao {
    // 用户注册
    public int add(User user) throws SQLException {
        int re = 0;
        // 添加的sql语句
        String sql = "INSERT INTO users(userName,password,sex,email)" + "VALUE (?,?,?,?)";
        // 获取数据库连接对象
        Connection connection = DBUtil.getconnection();
        // 获取数据库操作对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getSex());
        preparedStatement.setString(4, user.getEmail());

        re = preparedStatement.executeUpdate();
        // 关闭
        DBUtil.close(connection, preparedStatement, null);
        return re;
    }

    // 全部用户查询
    public List<User> findAll() throws SQLException {
        List<User> users = new LinkedList<User>();
        ResultSet resultSet;
        // 查询的sql语句
        String sql = "SELECT * FROM users";
        // 获取数据库连接对象
        Connection connection = DBUtil.getconnection();
        // 获取数据库操作对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int userID;
            String userName, password, sex, email;
            userID = resultSet.getInt("userID");
            userName = resultSet.getString("userName");
            password = resultSet.getString("password");
            sex = resultSet.getString("sex");
            email = resultSet.getString("email");
            User user = new User(userID, userName, password, sex, email);
            users.add(user);
        }
        // 关闭
        DBUtil.close(connection, preparedStatement, resultSet);
        return users;
    }

    // 用户删除
    public int delete(int userID) throws SQLException {
        int re = 0;
        // 删除的sql语句
        String sql = "DELETE FROM users WHERE userID=?";
        // 获取数据库连接对象
        Connection connection = DBUtil.getconnection();
        // 获取数据库操作对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, userID);

        re = preparedStatement.executeUpdate();
        // 关闭
        DBUtil.close(connection, preparedStatement, null);
        return re;
    }

    // 用户修改
    public int update(User user) throws SQLException {
        int re = 0;
        // 修改的sql语句
        String sql = "UPDATE users SET userName=?,password=?,sex=?,email=? WHERE userID=?";
        // 获取数据库连接对象
        Connection connection = DBUtil.getconnection();
        // 获取数据库操作对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getSex());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setInt(5, user.getUserId());
        re = preparedStatement.executeUpdate();
        // 关闭
        DBUtil.close(connection, preparedStatement, null);
        return re;
    }

    // 登录验证
    public int login(Map<Integer,String> map) throws SQLException {
        int re = 0;
        Connection connection;
        ResultSet resultSet;
        // 验证的sql语句
        String sql = "SELECT * FROM users WHERE userName=? AND password=?";
        // 获取数据库连接对象
        connection = DBUtil.getconnection();
        // 获取数据库操作对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, map.get(1));
        preparedStatement.setString(2, map.get(2));
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            re = 1;
        }
        return re;
    }
}
