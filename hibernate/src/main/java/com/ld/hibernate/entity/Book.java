package com.ld.hibernate.entity;

public class Book {

  private Integer id;
  private String isbn;
  private String title;
  private Double price;
  private Integer stock;

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", isbn='" + isbn + '\'' +
        ", title='" + title + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        '}';
  }

  public Book() {
  }

  public Book(Integer id, String isbn, String title, Double price, Integer stock) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.price = price;
    this.stock = stock;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }
}
