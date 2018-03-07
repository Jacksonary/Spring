package com.hhu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * 测试Hibernate的工作流程
 * Created by WeiguoLiu on 2018/3/1.
 */
public class HibernateTest {
    @Test
    public void test() {
        //1.创建SessionFactory对象
        SessionFactory sessionFactory = null;

        //1.2创建Configuration对象：对应hibernate的基本配置信息和对象关系应映射对象
        Configuration configuration = new Configuration().configure();

        //1.3创建ServiceRegistry对象,注意4.3以后的版本不再使用ServiceRegistryBuilder对象
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//                applySettings(configuration.getProperties()).build();
//
//        //创建SessionFactory
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        sessionFactory = configuration.buildSessionFactory();

        //2.创建一个Session
        Session session = sessionFactory.openSession();

        //3.开启事务
//        Transaction transaction = session.beginTransaction();

        //4.执行保存操作，开始需要指定数据的生成策略为create,后面要改成update
        Hibernate hibernate = new Hibernate("Hibernate TX", "trancation");
        hibernate.setDate(new Date());
        session.save(hibernate);

        //获取操作
//        Hibernate hibernate2 = session.get(Hibernate.class, 1);
//        System.out.println(hibernate2);

        //5.提交事务
//        transaction.commit();

        //6.关闭Session
        session.close();

        //7.关闭SessionFactory对象
        sessionFactory.close();

    }
}
