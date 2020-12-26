package controller.listener.requestlistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @version 1.0
 * @Description TODO
 * @Author MR
 * @Date 2020/12/26 18:57
 */
public class OneRequestListener implements ServletRequestListener {
    @Override
    /*监听销毁*/
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求作用域对象销毁成功！");
    }

    @Override
    /*监听创建*/
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求作用域对象创建成功！");
    }
}
