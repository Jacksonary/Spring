package com.hhu.springjdbc.springtx;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
public interface BookShopDao {
    //根据书的编号查询价格
    public int findBookPriceByIsbn(String isbn);

    //更新书的库存使其减一
    public void
    updateBookStock(String isbn);

    //更新用户的账户：当前余额-书的价格
    public void updateUserAccount(String username, int price);
}
