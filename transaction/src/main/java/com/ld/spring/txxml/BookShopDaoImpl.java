package com.ld.spring.txxml;

import com.ld.spring.exception.BookStockException;
import com.ld.spring.exception.UserAccountException;
import com.ld.spring.txxml.service.BookShopDao;
import org.springframework.jdbc.core.JdbcTemplate;


public class BookShopDaoImpl implements BookShopDao {

  private JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Integer findBookPriceByIsbn(String isbn) {
    String sql = "select price from book where isbn=?";
    return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
  }

  @Override
  public Integer findBookStockByIsbn(String isbn) {
    String sql = "select stock from book_stock where isbn=?";
    return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
  }

  @Override
  public void updateBookStockByIsbn(String isbn) {
    Integer bookStock = this.findBookStockByIsbn(isbn);
    if (!(bookStock > 0)) {
      throw new BookStockException("库存不够");
    } else {
      String sql = "update book_stock set stock = stock-1 where isbn = ?";
      int updatedRecord = jdbcTemplate.update(sql, isbn);
      System.out.println("stock is updated by -" + updatedRecord);
    }
  }

  @Override
  public Integer findAccountByUsername(String username) {
    String sql = "select balance from account where username=?";
    Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, username);
    System.out.println("user " + username + " account is " + balance);
    return balance;
  }

  @Override
  public void updateUserAccount(String username, Integer spending) {
    if (!(this.findAccountByUsername(username) >= spending)) {
      throw new UserAccountException("余额不够");
    } else {
      String sql = "update account set balance = balance-? where username = ?";
      int updatedRecord = jdbcTemplate.update(sql, spending, username);
      System.out.println("user" + username + " account is updated by -" + spending);
    }
  }
}
