package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserLogin extends HttpServlet {

    public UserLogin() {
        System.out.println("UserLogin 实例对象被创建！");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int re = 0;
        Map<Integer, String> map = new HashMap<Integer, String>();

        String userName = new String(request.getParameter("userName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(request.getParameter("password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        map.put(1, userName);
        map.put(2, password);
        try {
            re = userDao.login(map);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 设置Content-Type属性
        response.setContentType("text/html;charset=utf-8");
        // 获取（借）输出流
        PrintWriter out = response.getWriter();
        if (re == 1) {
            out.println("<font style='color:red;font-size:30'>登录成功</font>");
        } else {
            out.println("<font style='color:red;font-size:30'>登录失败</font>");
        }
    }

}
