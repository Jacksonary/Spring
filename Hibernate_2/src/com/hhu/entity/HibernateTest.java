package com.hhu.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by WeiguoLiu on 2018/3/5.
 */
public class HibernateTest {

    Configuration configuration = null;

    SessionFactory sessionFactory = null;

    //注意在实际生产过程中是不会将Session和Transaction搞成成员变量的，因为可能存在并发的问题
    Session session = null;

    Transaction tx = null;

    @Before
    public void setConfiguration() {
        //引入cfg的配置
        configuration = new Configuration().configure();

        //创建SessionFactory
        sessionFactory = configuration.buildSessionFactory();

        //打开会话
        session = sessionFactory.openSession();

        //开启事务
        tx = session.beginTransaction();
    }


    @Test
    public void test() {
        //获取ID为1的记录了
        HibernateEntity hibernateEntity = session.get(HibernateEntity.class, 1);
        System.out.println(hibernateEntity);

        HibernateEntity hibernateEntity2 = session.get(HibernateEntity.class, 1);
        System.out.println(hibernateEntity2);

        hibernateEntity.setName("test");
        session.save(hibernateEntity);
    }

    @Test
    public void testSave() {
        HibernateEntity h = new HibernateEntity();
        h.setName("testSave");
        h.setVersion("v2.1");
        session.save(h);
    }

    @Test
    public void testPersistence() {
        HibernateEntity h2 = new HibernateEntity();
        h2.setName("Persistence");
        h2.setVersion("P2");
        h2.setId(200);
        session.persist(h2);
    }

    @Test
    public void testGet() {
        HibernateEntity h = session.get(HibernateEntity.class, 200);
        System.out.println(h);
    }

    //LazyInitializationException
    @Test
    public void testLoad() {
        HibernateEntity h = session.load(HibernateEntity.class, 200);
        System.out.println(h);
    }

    @Test
    public void testSessionFlush() {
        HibernateEntity hibernateEntity = session.get(HibernateEntity.class, 1);
        hibernateEntity.setName("Session");
        //缓存指向数据库，不一致就发送相应的SQL语句使两者保持一致，但不会提交事务
        session.flush();
    }

    @Test
    public void testRefresh() {
        HibernateEntity h = session.get(HibernateEntity.class, 1);
        System.out.println(h);
        //refresh会强制发送SELECT语句使得Session缓存中的对象和数据库中的记录保持一致
        session.refresh(h);
        System.out.println(h);

    }

    @Test
    public void testUpdate() {
        HibernateEntity h = session.get(HibernateEntity.class, 200);
        h.setName("updatepoj");
    }

    @Test
    public void testSaveOrUpdate() {
        HibernateEntity h = new HibernateEntity();
        h.setName("saveOrUpdate");
        h.setVersion("saveOrUpdate");
        h.setId(10);
        session.saveOrUpdate(h);
    }

    @Test
    public void testDelete() {
        //1.删除持久化对象
        HibernateEntity h = session.get(HibernateEntity.class, 1);
        System.out.println(h);
        session.delete(h);
    }

    @Test
    public void testEvict() {
        HibernateEntity h = session.get(HibernateEntity.class, 2);
        h.setName("Evict3333");

        //将一个对象从缓存中移除
        session.evict(h);
    }

    @Test
    public void testDoWork() {
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection);
                //调用数据库的存储过程
            }
        });
    }

    @After
    public void after() {
        /*提交事务，在调用commit方法时，会自动先调用flush()方法
        但是除了commit()方法前会自动调用flush()方法外，还有其他情况可能会
        调用flush()方法，比如：
        1.执行HQL或QBC查询时，会执行flush()已得到数据表的最新记录
        2.若记录的ID是由底层数据库使用自增的方式生成，则在调用save()方法后会立即发送SQL语句
        ，因为在save()方法后，必须保证对象的ID是存在的，而采用native方式时，这个
        自增的ID是有数据库生成的，所以必须要在commit前发送SQL，comit后数据才能被数据库永久保存起来
         */
        tx.commit();

        //关闭会话
        session.close();

        //关闭会话工厂
        sessionFactory.close();
    }

}
