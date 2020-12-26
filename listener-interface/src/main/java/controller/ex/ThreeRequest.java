package controller.ex;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/26 19:03
 */
public class ThreeRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*添加*/
        req.setAttribute("name","bob");
        /*更新*/
        req.setAttribute("name","bob");
        /*移除*/
        req.removeAttribute("name");
    }
}
