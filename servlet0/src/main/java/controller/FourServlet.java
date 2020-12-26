package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 通过响应对象设置location来进行重定向（状态码302）
* 重定向请求方式：get（浏览器发起的地址栏请求）
* 实现方式：
*   response.sendRedirect(location);
*   location:
*       当前网站资源文件：/网站名称/资源文件
*       其他网站资源问文件地址：https://www.baidu.com（eg）
* 缺点：
*   1.重定向解决方案需要多次在浏览器和服务器往返，大量时间浪费，会增加用户的等待时间。
* */
public class FourServlet extends HttpServlet {
    public FourServlet() {
        System.out.println("FourServlet 实例对象被创建！");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = "https://www.baidu.com";
        /*通过响应对象给响应头的【location】赋值*/
        response.sendRedirect(location);
    }
}
