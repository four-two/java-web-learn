package com.jdbcABC;

/**
 * @version 1.0
 * @Description 模拟Oracle厂家的jdbc接口实现类
 * @Author MR
 * @Date 2020/12/21 20:33
 */
public class Oracle implements SunInterface{
    @Override
    public void getConnection() {
        System.out.println("连接oracle成功");
    }
}
