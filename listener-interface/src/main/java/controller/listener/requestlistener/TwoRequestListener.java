package controller.listener.requestlistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/26 18:58
 */
public class TwoRequestListener implements ServletRequestAttributeListener {
    @Override
    /*请求作用域对象添加数据调用*/
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("请求作用域对象数据添加数据啦！");
    }

    @Override
    /*请求作用域对象移除数据调用*/
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("请求作用域对象数据移除数据啦！");
    }

    @Override
    /*请求作用域对象更新数据调用*/
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("请求作用域对象数据更新数据啦！");
    }
}
