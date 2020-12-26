package com.jdbcABC;

/**
 * @version 1.0
 * @Description 模拟sqlserver厂家的jdbc接口实现类
 * @Author MR
 * @Date 2020/12/21 20:31
 */
public class Sqlserver implements SunInterface{
    @Override
    public void getConnection() {
        System.out.println("连接sqlserver成功");
    }
}
