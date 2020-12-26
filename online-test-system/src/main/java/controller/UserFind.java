package controller;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class UserFind extends HttpServlet {

    public UserFind() {
        System.out.println("UserFind 实例对象被创建！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<User> users;
        try {
            users = userDao.findAll();
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<table border='2' align='center'>");
            out.println("<tr>");
            out.println("<td>用户编号</td>");
            out.println("<td>用户名称</td>");
            out.println("<td>用户密码</td>");
            out.println("<td>用户性别</td>");
            out.println("<td>用户邮箱</td>");
            out.println("<td colspan=2>操作</td>");
            out.println("</tr>");
            for (User user : users) {
                out.println("<tr>");
                out.println("<td>" + user.getUserId() + "</td>");
                out.println("<td>" + user.getUserName() + "</td>");
                out.println("<td>" + "********" + "</td>");
                out.println("<td>" + user.getSex() + "</td>");
                out.println("<td>" + user.getEmail() + "</td>");
                out.println("<td><a href='/online_test_system/UserDelete?userId=" + user.getUserId() + "'>删除用户</td>");
                out.println("<td><a href='/online_test_system/UserAlter?userId=" + user.getUserId() + "'>修改用户</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
