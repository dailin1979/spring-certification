package com.ld.hibernate.service;

import java.util.List;

public interface Cashier {
  public void checkout(List<String> isbns, String username);
}
