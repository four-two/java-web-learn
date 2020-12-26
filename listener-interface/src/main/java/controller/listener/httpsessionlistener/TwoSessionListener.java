package controller.listener.httpsessionlistener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/26 18:06
 */
public class TwoSessionListener implements HttpSessionAttributeListener {

    @Override
    /*添加数据调用*/
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("会话作用域对象数据添加数据啦！");
    }

    @Override
    /*移除数据调用*/
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("会话作用域对象数据移除数据啦！");
    }

    @Override
    /*更新数据调用*/
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("会话作用域对象数据更新数据啦！");
    }
}
