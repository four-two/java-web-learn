package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 请求转发：
*   请求地址：只能是服务器内的资源文件地址（不用谢网站名）
*   实现方式：
*       request.getRequestDispatcher("资源文件位置").forward(request,response)
*   优点：
*       1.只需要浏览器发起一次请求
*       2.servlet互相调用在服务器完成，节省时间
*   请求方式：get和post都可能，由浏览器的请求方式决定。
* */
public class SixServlet extends HttpServlet {

    public SixServlet(){
        System.out.println("SixServlet 实例对象被初始化！");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SixServlet 洗韭菜！");
        // 向/SevenServlet发起请求并把当前响应对象和请求对象发送过去。
        request.getRequestDispatcher("/SevenServlet").forward(request,response);
    }
}
