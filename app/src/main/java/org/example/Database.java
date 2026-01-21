package org.example;

import java.math.BigDecimal;

public interface Database {
  Account getAccount(String username);

  interface Account {
    String username();

    void deposit(BigDecimal amount);

    void withdraw(BigDecimal amount);

    BigDecimal balance();
  }
}
