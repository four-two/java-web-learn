package controller;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description Servlet接口实现类
 * @Author MR
 * @Date 2020/12/22 16:53
 */

/*
 * 接口实现类开发步骤
 * 1.创建一个java类继承HttpServlet，使之成为一个Servlet接口的实现类
 *   HttpServlet继承于GenericServlet，GenericServlet继承于Servlet。
 * 2.重写HttpServlet的doGet和doPost方法（对应请求方式）
 *   HttpServlet的service方法判断请求方式并调用响应请求的处理方法doGet...
 * 3.将Servlet的接口实现类进行注册到Tomcat服务器
 *   WEB-INF/wen.xml
 *       接口实现类路径地址交给tomcat
 *       <servlet>
 *           <servlet-name>oneServlet</servlet-name> // 名称
 *           <servlet-class>controller.OneServlet</servlet-class> // 实现类路径
 *       </servlet>
 *       <servlet-mapping> // 设置请求别名
 *            <servlet-name>oneServlet</servlet-name> // 与servlet名称对应
 *           <url-pattern>/oneServlet</url-pattern> // 请求别名 以 / 开头
 *       </servlet-mapping>
 * */
public class OneServlet extends HttpServlet {

    public OneServlet() {
        System.out.println("OneServlet 实例对象被创建！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet Post is run...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OneServlet Get is run...");
    }
}
