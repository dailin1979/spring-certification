package com.ld.spring.tx;

import java.util.ArrayList;
import java.util.List;
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

  @Autowired
  private BookShopService bookShopService;

  @Autowired
  private Cashier cashier;


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

  @Test
  public void testBookShopService(){
//    Assert.assertNotNull(bookShopService);
    bookShopService.perchase("BB", "1001");
  }

  /*
  测试事务的传播属性， 可以通过tansactional的属性propagation定义
   */
  @Test
  public void testPropagationOfTransactional(){
    List<String> isbns = new ArrayList<>();
    isbns.add("1001");
    isbns.add("1002");
    isbns.add("1003");
    String username = "AA";

    cashier.checkout(isbns,username);
  }



}
