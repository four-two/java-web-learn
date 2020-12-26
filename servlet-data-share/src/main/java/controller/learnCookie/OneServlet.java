package controller.learnCookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @Description 利用Cookie使数据在servlet共享
 * @Author MR
 * @Date 2020/12/25 18:58
 */

/*
 * Cookie使用条件：
 *   需要调用的Servlet来自同一服务器（网站）
 *   同时为一个浏览器和用户服务
 * 储存位置：浏览器缓存（可指定存活时间）
 * 存储数据类型：String
 * 存储数据数量：使用map(只能有一个键值对)
 * Cookie里面有什么？
 *   浏览器（用户）的私人数据
 * Cookie工作原理：
 *   1.用户通过浏览器第一次想网站发起请求后，服务器Servlet将创建一个Cookie【含当前用户相关数据】写入响应头交还给浏览器。
 *   2.用户再次通过【同一浏览器】向【同一网站】发起请求时，浏览器将【Cookie写入请求头】发送给服务器以便Servlet获取数据。
 * 实现命令：
 *  创建：
 *      Cookie cookie = new Cookie("key", "value");// 都是String（map内含一个键值对）
 *      resp.addCookie(cookie);
 *  获取：
 *      Cookie[] cookies = request.getCookies();
 *      for (Cookie cookie:cookies){
 *          String key = cookie.getName();
 *          String value = cookie.getValue();
 *      }
 * 生命周期：
 *   Cookie对象存放在浏览器缓存里面，正常情况下，浏览器关闭，Cookie被销毁。
 *   可以手动设置浏览器储存Cookie在客户端硬盘，并指定储存时间。
 *      cookie.setMaxSge(单位秒)
 * */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            Cookie cookie1 = new Cookie("key1", "abms");
            Cookie cookie2 = new Cookie("key2", "学，学个屁！");
            cookie1.setMaxAge(10);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            resp.sendRedirect("/servlet_data_share/CTwo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
