package com.ld.hibernate.dao.iml;

import com.ld.hibernate.dao.BookShopDao;
import com.ld.hibernate.entity.Account;
import com.ld.hibernate.entity.Book;
import com.ld.hibernate.exception.AccountBalanceException;
import com.ld.hibernate.exception.BookStockException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {


  private SessionFactory sessionFactory;

//  可以使用spring的HibernateTemplate和HibernateDaoSupport
//  因为这样会导致spring和hibernate的API耦合，可移植性变差
//  private HibernateTemplate hibernateTemplate;

  @Autowired
  public BookShopDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

//  获取和当前线程绑定的Session, 前提式在cfg.xml中设置 hibernate.current_session_context_class
//  如果只是hibernate环境下， 可以使用thread, 如果是在spring context中，需要使用与hinbernate版本对应的SpringSessionContext
//  <property name="hibernate.current_session_context_class">
//      org.springframework.orm.hibernate4.SpringSessionContext
//    </property>
  private Session getSession(){
    return sessionFactory.getCurrentSession();
  }

  public BookShopDaoImpl() {
  }

  @Override
  public Double findBookPriceById(Integer id) {
    Book book = (Book) getSession().load(Book.class, id);
    return book.getPrice();
//    String hql = "select b.price from Book b where id = ?";
//    Query query = getSession().createQuery(hql).setInteger(0, id);
//    return (Double) query.uniqueResult();
  }

//  如果不通过主键查询数据表, 需要通过Query类实现
  @Override
  public Double findBookPriceByIsbn(String isbn) {
    String hql = "select b.price from Book b where b.isbn = ?";
    Query query = getSession().createQuery(hql).setString(0, isbn);
    return (Double) query.uniqueResult();
  }

  @Override
  public Integer findBookIdByIsbn(String isbn) {
    String hql = "select b.id from Book b where b.isbn = ?";
    Query query = getSession().createQuery(hql).setString(0, isbn);
    return (Integer) query.uniqueResult();
  }

  @Override
  public Integer findAccountIdByUsername(String username) {
    String hql = "select a.id from Account a where a.username = ?";
    Query query = getSession().createQuery(hql).setString(0, username);
    return (Integer) query.uniqueResult();
  }

  @Override
  public Integer findBookStockById(Integer id) {
    Book book = null;
    try {
      book = (Book) getSession().load(Book.class, id);
      return book.getStock();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Integer findBookStockByIsbn(String isbn) {
    String hql = "select b.id from Book b where b.isbn = ?";
    Integer stock = (Integer) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
    return this.findBookStockById(stock);
  }

  @Override
  public Double findBalanceById(Integer id) {
    Account account = null;
    try {
      account = (Account) getSession().load(Account.class, id);
      return account.getBalance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Double findBalanceByUsername(String username) {
    String hql = "select a.id from Account a where a.username = ?";
    Integer id = (Integer) getSession().createQuery(hql).setString(0, username).uniqueResult();
    return this.findBalanceById(id);
  }

  @Override
  public void updateBookStockById(Integer id, Integer newStock) {
// 验证书的库存是不是充足
    if(this.findBookStockById(id)!=null){
      Book book = (Book) getSession().get(Book.class, id);
      book.setStock(newStock);
      getSession().saveOrUpdate(book);
    } else {
      throw new BookStockException("库存不足");
    }
  }

  @Override
  public void updateUserAccountById(Integer id, Double spending) {
// 验证此用户的余额是否足够
    if(this.findBalanceById(id)!=null){
      Account account = (Account) getSession().get(Account.class, id);
      Double newBalance = account.getBalance() - spending;
      System.out.println("账号信息修改qian" + account.toString());
      if(newBalance < 0){
        throw new AccountBalanceException("余额不足");
      }
      account.setBalance(newBalance);
      getSession().saveOrUpdate(account);
      System.out.println("账号信息修改后" + account.toString());
    } else {
      throw new AccountBalanceException("余额不足");
    }
  }
}
