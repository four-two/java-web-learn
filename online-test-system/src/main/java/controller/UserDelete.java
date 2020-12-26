package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserDelete extends HttpServlet {

    public UserDelete() {
        System.out.println("UserDelete 实例对象被创建！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int userId, re = 0;
        userId = Integer.parseInt(request.getParameter("userId"));

        try {
            re = userDao.delete(userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 设置Content-Type属性
        response.setContentType("text/html;charset=utf-8");
        // 获取（借）输出流
        PrintWriter out = response.getWriter();
        if (re==1){
            out.println("<font style='color:red;font-size:30'>删除成功</font>");
        }else {
            out.println("<font style='color:red;font-size:30'>删除失败</font>");
        }
    }
}
