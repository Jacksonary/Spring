package com.hhu.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //测试连接
    @Test
    public void testConnection() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试增删改查
    @Test
    public void testInsert() {
        String sql = "insert into t_user(userName, password)values(?,?)";
        jdbcTemplate.update(sql, "insert", "insert");
    }

    @Test
    public void testDelete() {
        String sql = "delete from t_user where id = ?";
        jdbcTemplate.update(sql, 2);
    }

    @Test
    public void testUpdate() {
        String sql = "update t_user set userName = ?,password = ? where id = ?";
        jdbcTemplate.update(sql, "Spring", "Spring", 1);
    }

    /**
     * 批量更新：包括增、删、改
     */
    @Test
    public void testBatchUpdate() {
        String sql = "insert into t_user(userName, password) values(?, ?)";

        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"insert1", "insert1"});
        batchArgs.add(new Object[]{"insert2", "insert2"});
        batchArgs.add(new Object[]{"insert3", "insert3"});

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 从数据库中获取一条记录，而实际需要得到一个对象,
     * 但是SpringTemplate不支持级联属性，即不能通过用户的car的id查询到car的具体属性
     * 所以它是JDBC的小工具而不是ORM框架
     */
    @Test
    public void testQueryForObject() {
        String sql = "select * from t_user where id = ?";
        //指定映射的而类型
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        //三个参数：sql，映射类型，待传入的参数id
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 3);
        System.out.println(user);
    }

    /**
     * 查询一组记录并映射到现有的对象上
     */
    @Test
    public void testQueryForList() {
        String sql = "select * from t_user where id > ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> list = jdbcTemplate.query(sql, rowMapper, 2);
        for (User u : list) {
            System.out.println(u);
        }
    }

}
