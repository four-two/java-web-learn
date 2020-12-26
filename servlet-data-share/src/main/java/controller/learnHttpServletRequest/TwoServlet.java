package controller.learnHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = (String)request.getAttribute("key1");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out  = response.getWriter();
        out.println(s+"</br>");
    }
}
