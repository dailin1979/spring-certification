package com.ld.hibernate.exception;

public class AccountBalanceException extends RuntimeException {

  public AccountBalanceException() {
  }

  public AccountBalanceException(String message) {
    super(message);
  }

  public AccountBalanceException(String message, Throwable cause) {
    super(message, cause);
  }

  public AccountBalanceException(Throwable cause) {
    super(cause);
  }

  protected AccountBalanceException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
