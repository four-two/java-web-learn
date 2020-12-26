package controller;
/**
 * @version 1.0
 * @Description Servlet生命周期演示
 * @Author MR
 * @Date 2020/12/22 16:53
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Servlet生命周期
* 1.所有接口实现类的实例由服务器来创建
* 2.默认情况下服务器第一次接收一个接口实现类的请求是时就创建这个类的实例
* 3.可以手动配置在服务器启动时创建接口实现类的实例
*   <load-on-startup>2</load-on-startup>
*       默认为0，越大优先级越高
* 4.运行期间一个接口实现类只能有一个实例对象
* 5.服务器关闭时，会销毁所有Servlet对象
* */
public class TwoServlet extends HttpServlet {
    public TwoServlet(){
        System.out.println("TwoServlet 实例对象被创建！");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet Post is run...");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet Get is run...");

    }
}
