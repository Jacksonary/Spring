package com.hhu.springjdbc.springtx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {

        String sql2 = "select num from book_stock where isbn = ?";
        int num = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (num == 0) {
            throw new NumException("库存不足");
        }

        String sql = "update book_stock set num = num - 1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserAccount(String userName, int price) {
        String sql2 = "select balance from account where userName = ?";
        int balance = jdbcTemplate.queryForObject(sql2, Integer.class, userName);
        if(balance<price) {
            throw new AccountException("账户余额不足");
        }

        String sql = "update account set balance = balance - ? where userName = ?";
        jdbcTemplate.update(sql, price, userName);
    }
}
