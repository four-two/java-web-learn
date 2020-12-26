package controller;

/**
 * @version 1.0
 * @Description HttpServletResponse学习
 * @Author MR
 * @Date 2020/12/22 16:53
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/*
 * HttpServletResponse
 * 请求对象：HttpServletResponse接口修饰的对象
 * 功能：
 *   1.读取http请求协议包里【请求行】信息
 *   2.读取http请求协议包里【请求头】或【请求体】中的参数信息
 *      请求头：Tomcat使用utf-8解码
 *      请求体：当前请求对象使用ISO_8859_1解码
 *   3.代替浏览器向http服务器申请资源文件的调用（.class文件）
 * */
public class FiveServlet extends HttpServlet {

    public FiveServlet() {
        System.out.println("FiveServlet 实例对象被创建！");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getHttpHead(request);
        // 读取http请求协议包里【请求体】(post)中的参数信息
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            /*获取参数名称*/
            String parameterName = (String) parameterNames.nextElement();
            /*
            * 根据名称获取参数值
            * 设置编码
            * */
            String value = new String(request.getParameter(parameterName).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            System.out.println(parameterName + ":" + value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getHttpHead(request);
        // 读取http请求协议包里【请求头】(get)中的参数信息
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            /*获取参数名称*/
            String parameterName = (String) parameterNames.nextElement();
            /*根据名称获取参数值*/
            String value = request.getParameter(parameterName);

            System.out.println(parameterName + ":" + value);
        }
    }

    static void getHttpHead(HttpServletRequest request){
        // 读取http请求协议包里【请求行】信息
        /*获取请求行的url*/
        String url = request.getRequestURL().toString();
        System.out.println("URL: " + url);
        /*获取请求行的method*/
        String method = request.getMethod();
        System.out.println("Method: " + method);
        /*获取请求行的uri(/网站名/资源文件名)*/
        String uri = request.getRequestURI();
        System.out.println("URI: " + uri);
    }
}
