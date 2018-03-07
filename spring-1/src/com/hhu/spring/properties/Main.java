package com.hhu.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by WeiguoLiu on 2018/2/26.
 */
public class Main {
//    private static String userName = "root";
//    private static String password = "921228jack";
//    private static String jdbcUrl = "jdbc:mysql://localhost:3306/seckill";
//    //    private static String driverClass = "com.mysql.cj.jdbc.Driver";
//    private static String driverClass = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        //加载驱动
//        try {
//            Class.forName(driverClass);
//            Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
//            System.out.println(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
