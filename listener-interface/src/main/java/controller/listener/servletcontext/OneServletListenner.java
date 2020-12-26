package controller.listener.servletcontext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @version 1.0
 * @Description 实现全局作用域对象监听接口创建监听
 * @Author MR
 * @Date 2020/12/26 17:40
 */
public class OneServletListenner implements ServletContextListener {
    /*全局作用域对象创建时调用*/
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("全局作用域对象创建成功！");
    }
    /*全局作用域对象销毁时调用*/
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("全局作用域对象销毁成功！");
    }
}
