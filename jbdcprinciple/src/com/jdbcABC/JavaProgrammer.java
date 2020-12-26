package com.jdbcABC;

import java.util.ResourceBundle;

/**
 * @version 1.0
 * @Description 模拟程序员调用JDBC接口
 * @Author MR
 * @Date 2020/12/21 20:35
 */
public class JavaProgrammer {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

//        普通创建
//        SunInterface sunInterface = new Mysql();
//        sunInterface.getConnection();

//        通过反射创建
//        Class<?> c = Class.forName("com.jdbcABC.Mysql");
//        SunInterface sunInterface1= (SunInterface) c.newInstance();
//        sunInterface1.getConnection();

//        通过反射和配置文件创建
        ResourceBundle resource = ResourceBundle.getBundle("com/jdbcABC/conf/jdbc");
        String classname = resource.getString("classname");
        Class<?> c = Class.forName(classname);
        SunInterface sunInterface2= (SunInterface) c.newInstance();
        sunInterface2.getConnection();

    }
}
