package com.ld.spring.tx;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:application-context-transaction.xml")
public class SpringTransactionTest {

  @Autowired
  private BookshopDao bookshopDao;

/*
通过注解，可以将下列的code省略，直接通过注解装配bean
  private ApplicationContext ctx;
  {
    ctx = new ClassPathXmlApplicationContext("application-context-transaction.xml");
    bookshopDao = ctx.getBean(BookshopDao.class);
  }
  */

  @Test
  public void testBookshopDaoFindBookPriceByIsbn(){
    Integer price = bookshopDao.findBookPriceByIsbn("1001");
    System.out.println(price);
  }

  @Test
  public void testBookshopDaoUpdateBookStockByIsbn(){
    bookshopDao.updateBookStockByIsbn("1002");
    Integer stock = bookshopDao.findBookStockByIsbn("1002");
    System.out.println(stock);
  }

  @Test
  public void testBookshopDaoUpdateUserAccount(){
    bookshopDao.updateUserAccount("AA", 100);
  }


}
