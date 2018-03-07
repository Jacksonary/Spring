package com.hhu.service.impl;

import com.hhu.dao.BookShopDao;
import com.hhu.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WeiguoLiu on 2018/3/3.
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /*这个是买一本书，Spring、Hibernate的事务流程
    1.在方法开始之前获取Session，这样就可以在Dao中使用SessionFactory的
    getCurrentSession()方法获取Session了，开启事务；
    2.如果方法正常执行，则提交事务，如果方法出现异常就回滚事务，然后和当前线程绑定的
    Session解除绑定，最后关闭Session.
     */

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String userName, String isbn) {
        System.out.println("isbn's price:" + bookShopDao.findBookPriceByIsbn(isbn));
        //1.更新数目使其减一
        bookShopDao.updateBookStock(isbn);
        //2.更新账户余额，使余额减去书本价格
        bookShopDao.updateUserAccount(userName, bookShopDao.findBookPriceByIsbn(isbn));
    }
}
