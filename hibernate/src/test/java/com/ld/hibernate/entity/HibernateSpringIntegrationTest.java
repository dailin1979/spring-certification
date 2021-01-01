package com.ld.hibernate.entity;

import com.ld.hibernate.dao.BookShopDao;
import com.ld.hibernate.exception.AccountBalanceException;
import com.ld.hibernate.exception.BookStockException;
import com.ld.hibernate.service.BookShopService;
import com.ld.hibernate.service.Cashier;
import java.sql.SQLException;
import java.util.Arrays;
import javax.sql.DataSource;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试Dao的方法是，需要在application-context.xml中配置事务切点时，
 * 将 <aop:pointcut id="txPointcut" expression="execution(* com.ld.hibernate.dao.*.*(..))"/> 解除注释
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:application-context.xml")
public class HibernateSpringIntegrationTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  BookShopDao bookShopDao;

  @Autowired
  BookShopService bookShopService;

  @Autowired
  Cashier cashier;

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void testDataSource(){
    try {
      System.out.println(dataSource.getConnection());
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  @Test
  public void testFindBookPriceById(){
    Double bookPriceByIsbn = bookShopDao.findBookPriceById(1);
    System.out.println(bookPriceByIsbn);
  }

  @Test
  public void testfindBookPriceByIsbn(){
    Double bookPriceByIsbn = bookShopDao.findBookPriceByIsbn("1001");
    System.out.println(bookPriceByIsbn);
  }

  @Test
  public void testfindBookStockByIsbn(){
    Integer stock = bookShopDao.findBookStockByIsbn("1001");
    System.out.println(stock);
  }

  @Test
  public void testfindBookIdByIsbn(){
    Integer bookId = bookShopDao.findBookIdByIsbn("1001");
    System.out.println(bookId);
  }

  @Test
  public void testFindBalanceByUsername(){
    Double balanceOfTom = bookShopDao.findBalanceByUsername("tom");
    System.out.println(balanceOfTom);
  }

  @Test
  public void testFindAccountIdByUsername(){
    Integer id = bookShopDao.findAccountIdByUsername("tom");
    System.out.println(id);
  }

  @Test
  public void testUpdateBookStockByIdWithException(){
    exceptionRule.expect(BookStockException.class);
    bookShopDao.updateBookStockById(3, 30);
  }

  @Test
  public void testUpdateBookStockById(){
    bookShopDao.updateBookStockById(2, 30);
  }

  @Test
  public void testUpdateUserAccountByIdWithException01(){
    exceptionRule.expect(AccountBalanceException.class);
    bookShopDao.updateUserAccountById(3, 300.0);

  }
  @Test
  public void testUpdateUserAccountByIdWithException02(){
    exceptionRule.expect(AccountBalanceException.class);
    bookShopDao.updateUserAccountById(1, 1000.00);
  }

  @Test
  public void testUpdateUserAccountByIdWithoutException(){
    bookShopDao.updateUserAccountById(1, 5.75);
  }

  @Test
  public void testPerchaseInBookShopSerivce(){
    bookShopService.perchase("tom", "1001");
  }

  @Test
  public void testPerchaseInBookShopSerivceWithExpectedException(){
    exceptionRule.expect(AccountBalanceException.class);
    bookShopService.perchase("tom", "1003");
  }

  @Test
  public void testCheckout(){
    exceptionRule.expect(AccountBalanceException.class);
    cashier.checkout(Arrays.asList("1001", "1003"), "tom");
  }



}