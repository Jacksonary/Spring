package com.hhu.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by WeiguoLiu on 2018/3/6.
 */
public class WorkTest {

    private Configuration configuration = null;
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction tx = null;

    @Before
    public void init() {
        //创建配置文件
        configuration = new Configuration().configure();
        //搞一个SessionFactory
        sessionFactory = configuration.buildSessionFactory();

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }


    @After
    public void destory() {
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSave() {
        Work w = new Work();
        Pay p = new Pay();
        p.setMonthPay(100);
        p.setYearPay(1000);
        p.setRestPay(10);

        w.setName("testUser");
        w.setPay(p);
        session.save(w);
    }

}
