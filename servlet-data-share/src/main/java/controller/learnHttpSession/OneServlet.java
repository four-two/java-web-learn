package controller.learnHttpSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * @Description HttpSession实现servlrt共享数据
 * @Author MR
 * @Date 2020/12/25 18:59
 */

/*
 * HttpSession
 * 使用条件：
 *   需要调用的Servlet来自同一服务器（网站）
 *   同时为一个浏览器和用户服务
 * 会话作用域对象：HttpSession接口的修饰对象
 * 储存位置：服务端计算机内存
 * 存储数据类型：任意类型
 * 存储数据数量：使用map(任意数量)
 * 命名实现：
 *   索要HttpSession：
 *      HttpSession httpSession =request.getSession();
 *   添加数据：
 *      httpSession.setAttribute("key",Object);
 *   获取数据：
 *      httpSession.getAttributeNames()// 获取所有名称
 *      httpSession.getAttribute("key");
 * 服务器如何关联用户与HttpSession（利用cookie）？
 *    服务器在创建一个HttpSession时会创建一个唯一id（保存在cookie）并返回给浏览器储存在缓存里面
 *    用户（浏览器）第二次访问时，浏览器把id放在请求头发送过去，服务器再根据id获取对应的Session
 * getSession()和getSession(false)
 *    getSession()：有就返回没有就创建返回
 *    getSession(false)：有就赶回没有返回null
 * 生命周期：
 *    1.浏览器关闭时清除cookie并不会清除服务器储存的HttpSession
 *    2.可以设置HttpSession的空闲时间来管理销毁
 *         /web/WEB-INF/web.xml
 *         <session-config>
 *               <!--单位分钟-->
 *               <session-timeout>5</session-timeout>
 *          </session-config>
 *    3.默认30分钟空闲就自动销毁
 * */
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("key1")==null){
            httpSession.setAttribute("key1","你好 HttpSession");
            httpSession.setAttribute("key2",1);
        }else {
            Integer i= (Integer)httpSession.getAttribute("key2")+1;
            String s = "第"+i+"次见面 HttpSession";
            httpSession.setAttribute("key2",i);
            httpSession.setAttribute("key1",s);
        }
        req.getRequestDispatcher("/STwo").forward(req,resp);
    }
}
