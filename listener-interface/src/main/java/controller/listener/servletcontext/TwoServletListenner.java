package controller.listener.servletcontext;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @version 1.0
 * @Description 实现全局作用域对象数据改变监听接口
 * @Author MR
 * @Date 2020/12/26 17:48
 */
public class TwoServletListenner implements ServletContextAttributeListener {
    @Override
    /*添加数据监听*/
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("全局作用域对象有新数据啦！" + scae.getName());
    }

    @Override
    /*移除数据监听*/
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("全局作用域对象删除数据啦！" + scae.getName());
    }

    @Override
    /*更新数据监听*/
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("全局作用域对象更新啦！" + scae.getName());
    }
}
