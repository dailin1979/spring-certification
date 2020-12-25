package com.ld.spring.txxml.service;

public interface BookShopDao {

  public Integer findBookPriceByIsbn(String isbn);

  public Integer findBookStockByIsbn(String isbn);

  public Integer findAccountByUsername(String username);

  public void updateBookStockByIsbn(String isbn);

  public void updateUserAccount(String username, Integer spending);


}
