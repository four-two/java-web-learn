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
import java.util.Enumeration;

public class UserAdd extends HttpServlet {

    public UserAdd() {
        System.out.println("UserAdd 实例对象被初始化！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        User user = null;
        UserDao userDao = new UserDao();
        int re = 0;
        // 读取请求头里面的参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        user = new User(null, userName, password, sex, email);

        try {
            re = userDao.add(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 设置Content-Type属性
        response.setContentType("text/html;charset=utf-8");
        // 获取（借）输出流
        PrintWriter out = response.getWriter();
        if (re == 1) {
            out.println("<font style='color:red;font-size:30'>添加成功</font>");
        } else {
            out.println("<font style='color:red;font-size:30'>添加失败</font>");
        }
    }
}
