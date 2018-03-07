package com.hhu.springjdbc.springtx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    //实现一个账户买多本书,这里是将买多本书作为一种新的事务，就是该账户一定
    //要买这么多书，少一本都不行，原先的账户余额检测和书本库存的检测买卖成功的事务仍然成功
    @Transactional
    @Override
    public void checkout(String userName, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(userName, isbn);
        }
    }
}
