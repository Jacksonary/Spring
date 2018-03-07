package com.hhu.dao;

import com.hhu.exception.AccountException;
import com.hhu.exception.StockException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by WeiguoLiu on 2018/3/3.
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {

    //Hibernate中的SessionFactory是线程安全的
    @Autowired
    private SessionFactory sessionFactory;

    /*
    当然除了上面使用Hibernate的原生的SessionFactory的接口，还可以使用Spring提供的
    HibernateTemplate，但是这种方式是不推荐的，因为使用后不便一致，用原生的Hibernate
    提供的接口，可以直接利用单独的Hibernate的移植，如果再搞一个Spring的接口，移植的
    时候就必须引入Spring和Hibernate两者依赖，导致Dao和Spring的API耦合，所以不推荐使用
     */
    private HibernateTemplate hibernateTemplate;

    private Session getSession() {
        //获取跟当前线程绑定的Session
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String hql = "Select b.price FROM StudentBook b WHERE b.isbn = ?";
        Query query = getSession().createQuery(hql).setParameter(0, isbn);
        return (Integer) query.uniqueResult();
    }

    @Override
    public void updateBookStock(String isbn) {
        //因为MySQL不支持验证，所以使用Hibernate还是需要进行库存的验证
        String hql2 = "SELECT b.stock FROM StudentBook b WHERE b.isbn = ?";
        int stock = (int) getSession().createQuery(hql2).setParameter(0, isbn).uniqueResult();
        //库存不够时，抛出异常
        if (stock < 1) {
            throw new StockException("库存不足！");
        }
        String hql = "UPDATE StudentBook b SET b.stock = b.stock - 1 WHERE b.isbn = ?";
        getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();
    }

    @Override
    public void updateUserAccount(String username, int price) {
        //验证余额是否足够
        String hql2 = "SELECT a.balance FROM StudentAccount a WHERE a.userName = ?";
        int balance = (int) getSession().createQuery(hql2).setParameter(0, username).uniqueResult();
        if (balance < price) {
            throw new AccountException("账户余额不足！");
        }
            String hql = "UPDATE StudentAccount a SET a.balance = a.balance - ? WHERE a.userName = ?";
            Query query = getSession().createQuery(hql);
            query.setParameter(0, price);
            query.setParameter(1, username);
            query.executeUpdate();
    }
}
