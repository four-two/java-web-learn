package controller.ex;
/**
 * @version 1.0
 * @Description 模拟添加、更新、移除全局作用域对象中的数据
 * @Author MR
 * @Date 2020/12/26 17:40
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class oneServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*添加共享数据*/
        request.getServletContext().setAttribute("name","吕文浩");
        /*更新共享数据*/
        request.getServletContext().setAttribute("name","吕文浩");
        /*移除共享数据*/
        request.getServletContext().removeAttribute("name");
    }
}
