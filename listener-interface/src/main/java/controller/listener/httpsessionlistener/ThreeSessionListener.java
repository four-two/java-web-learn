package controller.listener.httpsessionlistener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @version 1.0
 * @Description javaweb持久化以后慢慢看，有点晕。
 * @Author MR
 * @Date 2020/12/26 18:09
 */
public class ThreeSessionListener implements HttpSessionActivationListener {

    @Override
    /*Session被钝化(从内存到硬盘)调用*/
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("Session被钝化(从内存到硬盘)");
    }

    @Override
    /*Session被活化(从硬盘到内存)调用*/
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("Session被活化(从硬盘到内存)");
    }
}
