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
import java.io.PrintWriter;
/*
* HttpServletResponse
* 响应对象：HttpServletResponse接口修饰的对象
* 功能：
*   1.将doXX执行结果以二进制写入响应体并交给浏览器
*   2.设置【content-type】属性，使浏览器按照响应的编译器编译【图片、文字、视频、命令】
*       【content-type】默认为：text（文本编译器）
*                        可选：text/html ： HTML格式
*                             text/plain ：纯文本格式
*                             text/xml ：  XML格式
*                             image/gif ：gif图片格式
*                             image/jpeg ：jpg图片格式
*
*     image/png ：png图片格式
*                             ...
*       同时可以设置字符格式：如text/html;charset=utf-8
*   3.设置【location】属性，将请求地址赋值给location，使浏览器向指定服务发送请求。
*
* */
public class ThreeServlet extends HttpServlet {

    public ThreeServlet() {
        System.out.println("ThreeServlet 实例对象被创建！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*模拟doget处理结果*/
        String re = "hello ThreeServlet<br/>hello HttpServletResponse<br/>hello setContentType<br/>";
        String re_ = "苹果<br/>香蕉<br/>梨";
//        int re = 97;
        // 将响应对象写入响应体
        /*修改【content-type】属性*/
        response.setContentType("text/html;charset=utf-8");
        /*通过响应对象，向服务器要输出流*/
        PrintWriter out = response.getWriter();
        /*将执行结果以二进制写入响应体*/
        /*字符ascll值*/
//        out.write(re);
        /*任意类型*/
        out.println(re);
        out.println(re_);
    }
}
