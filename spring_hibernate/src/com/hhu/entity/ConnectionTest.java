package com.hhu.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * Created by WeiguoLiu on 2018/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
