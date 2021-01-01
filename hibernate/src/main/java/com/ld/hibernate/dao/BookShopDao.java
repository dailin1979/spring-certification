package com.ld.hibernate.dao;

public interface BookShopDao {

  public Double findBookPriceById(Integer id);

  public Double findBookPriceByIsbn(String isbn);

  public Integer findBookIdByIsbn(String isbn);

  public Integer findBookStockById(Integer id);

  public Integer findBookStockByIsbn(String isbn);

  public Double findBalanceById(Integer id);

  public Double findBalanceByUsername(String username);

  public Integer findAccountIdByUsername(String username);

  public void updateBookStockById(Integer id, Integer newStock);

  public void updateUserAccountById(Integer id, Double spending);

}
