package controller.learnHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description HttpServletRequest接口实现数据集共享
 * @Author MR
 * @Date 2020/12/25 18:59
 */

/*
* 使用条件：两个Servlet使用请求转发进行调用，利用其共享的请求对象request进行数据共享
* 请求作用域对象：实现数据共享的请求对象request
* 实现命令：
*   request.setAttribute("key",Object);
*   (Object)request.getAttribute("key");
* 生命周期：同响应对象
* */
public class OneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("key1","你好");
        request.getRequestDispatcher("/RTwo").forward(request,response);
    }
}
