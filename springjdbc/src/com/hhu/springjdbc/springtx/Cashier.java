package com.hhu.springjdbc.springtx;

import java.util.List;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
public interface Cashier {
    //一个买多本书
    public void checkout(String userName, List<String> isbn);
}
