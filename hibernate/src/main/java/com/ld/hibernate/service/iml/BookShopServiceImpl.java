package com.ld.hibernate.service.iml;

import com.ld.hibernate.dao.BookShopDao;
import com.ld.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

  private BookShopDao bookShopDao;

  public BookShopServiceImpl() {
  }

  @Autowired
  public BookShopServiceImpl(BookShopDao bookShopDao) {
    this.bookShopDao = bookShopDao;
  }


  @Override
  public void perchase(String username, String isbn) {
    Double price = bookShopDao.findBookPriceByIsbn(isbn);
    Integer bookId = bookShopDao.findBookIdByIsbn(isbn);
    Integer accountId = bookShopDao.findAccountIdByUsername(username);
    Integer stock = bookShopDao.findBookStockById(bookId);
    bookShopDao.updateUserAccountById(accountId, price);
    bookShopDao.updateBookStockById(bookId,stock-1);
  }
}
