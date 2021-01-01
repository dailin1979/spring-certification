package com.ld.hibernate.exception;

public class BookStockException extends RuntimeException {

  public BookStockException() {
  }

  public BookStockException(String message) {
    super(message);
  }

  public BookStockException(String message, Throwable cause) {
    super(message, cause);
  }

  public BookStockException(Throwable cause) {
    super(cause);
  }

  protected BookStockException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
