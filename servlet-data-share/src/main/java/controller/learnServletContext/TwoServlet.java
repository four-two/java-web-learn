package controller.learnServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @version 1.0
 * @Description ServletContext接口学习 从全局作用域取数据
 * @Author MR
 * @Date 2020/12/25 18:58
 */
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer num = (Integer) request.getServletContext().getAttribute("key1");
        System.out.println(num);
    }
}
