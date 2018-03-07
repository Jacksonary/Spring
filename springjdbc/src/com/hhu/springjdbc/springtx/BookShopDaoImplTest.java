package com.hhu.springjdbc.springtx;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookShopDaoImplTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Autowired
    private BookShopDao bookShopDao;

    @Autowired
    private BookShopService bookShopService;

    @Autowired
    private Cashier cashier;

    @Test
    public void findBookPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("123"));
    }

    @Test
    public void updateBookStock() {
        bookShopDao.updateBookStock("123");
    }

    @Test
    public void updateUserAccount() {
        bookShopDao.updateUserAccount("jack", 30);
    }

    @Test
    public void testService() {
        //此时测试库存足但是余额不足的情况，发现余额抛异常不变，但是库存还是减了
        bookShopService.purchase("jack", "123");
    }

    @Test
    public void testTranctionPro() {
        cashier.checkout("jack", Arrays.asList("123", "234"));
    }

}
