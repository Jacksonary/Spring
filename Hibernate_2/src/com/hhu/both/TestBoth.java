package com.hhu.both;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by WeiguoLiu on 2018/3/6.
 */
public class TestBoth {
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
    public void testCreate() {

    }

    @Test
    public void testSave() {
        Customer c1 = new Customer();
        c1.setCName("Customer1");

        Order o1 = new Order();
        o1.setOName("Order1");

        Order o2 = new Order();
        o2.setOName("Order2");

        //关联多对一
        o1.setCustomer(c1);
        o2.setCustomer(c1);

        //关联一对多
        c1.getOrders().add(o1);
        c1.getOrders().add(o2);


       //先插入customer再插入order
        session.save(c1);
        session.save(o1);
        session.save(o2);

        /*
        先插入Order，再插入Customer，这样的方式会多出update语句，因为没有对应Customer
        所以在插入Order时会先让CustomerID这个外键为空，等插入Customer后，在对插入的Order进行
        更新，这样的方式由于多出这几条update语句会让SQL执行效率下降，不如上面的方式
        */
//        session.save(o1);
//        session.save(o2);
//        session.save(c1);

    }

    @Test
    public void testMany2One() {
        //这里是查询关联关系，而不是简单的查询Order中Customer的外键，也要通过这个外键将对应的Customer查询出来
        Order o = session.get(Order.class, 1);
        System.out.println(o.getOName());


        /*上述的方式只是查询了Order，并没有查询关联的Customer(仅仅有一个外键的ID),在等到需要用到的时候才会去查询这个Customer
         对象在使用到这个对象的时候才会发送相应的SQL语句，这就叫延迟加载，同样的在对Customer加载时可能会出现懒加载异常(Session
         关闭时)
         */
        Customer c = o.getCustomer();
        System.out.println(c.getCName());
    }

    @Test
    public void testUpdate() {
        Order o = session.get(Order.class, 1);
        o.getCustomer().setCName("AA");
    }

    @Test
    public void testDelete() {
        //在没有设定级联关系(比如级联删除)的情况下，是不能直接删除Customer的，因为它在Order作为外键被某些Order对象引用
        Customer c = session.get(Customer.class, 1);
        session.delete(c);
    }
}
