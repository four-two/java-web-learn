package controller.listener.httpsessionlistener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/26 18:03
 */
public class OneSessionListener implements HttpSessionListener {

    @Override
    /*监听创建*/
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("会话作用域对象创建成功！"+ se.getSession().getId());
    }

    @Override
    /*监听销毁*/
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("会话作用域对象销毁成功！"+ se.getSession().getId());
    }
}
