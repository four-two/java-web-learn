package controller.learnServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description ServletContext接口学习
 * @Author MR
 * @Date 2020/12/25 18:58
 */

/*
* ServletContext接口：javax.servlet.jsp实现
*   全局作用对象：ServletContext实例对象（可以理解为全局变量）
*   存储方式：相当于一个Map（键值对存储）
*   生命周期：
*       http服务启动时，服务器在当前网站创建一个全局作用域对象
*       http服务服务运行期间，一个网站只有一个全局作用域对象
*       http服务关闭时，销毁
*   共享数据：
*       1.通过request向服务器索要ServletContext并将数据添加到全局作用域对象里面
*           request.getServletContext().setAttribute(String key, Object object)
*       3.通过request向服务器索要ServletContext并根据key获取object
*
* */
public class OneServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request向服务器索要ServletContext
        ServletContext servletContext = request.getServletContext();
        // 将数据添加到全局作用域对象里面
        // void setAttribute(String var1, Object var2);
        servletContext.setAttribute("key1",100);
        // 请求转发
        request.getRequestDispatcher("/SCTwo").forward(request,response);
    }
}
