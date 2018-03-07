package com.hhu.service.impl;

import com.hhu.dao.BookShopDaoImpl;
import com.hhu.service.BookShopService;
import com.hhu.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WeiguoLiu on 2018/3/3.
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void checkout(String userName, List<String> isbn) {
        for (String s : isbn) {
            //单独买书的业务本来就有一个自己的事务
            bookShopService.purchase(userName, s);
        }
    }
}
