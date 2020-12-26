package controller.ex;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/26 18:21
 */
public class TwoSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        /*会话作用域对象添加数据集*/
        httpSession.setAttribute("name","bob");
        /*会话作用域对象更新数据集*/
        httpSession.setAttribute("name","tom");
        /*会话作用域对象移除数据集*/
        httpSession.removeAttribute("name");
    }
}
