package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class InMemoryDatabase implements Database {
  private final Map<String, Account> accounts = new HashMap<>();

  @Inject
  InMemoryDatabase() {}

  @Override
  public Account getAccount(String username) {
    return accounts.computeIfAbsent(username, InMemoryAccount::new);
  }

  private static final class InMemoryAccount implements Account {
    private final String username;
    private BigDecimal balance = BigDecimal.ZERO;

    InMemoryAccount(String username) {
      this.username = username;
    }

    @Override
    public String username() {
      return username;
    }

    @Override
    public void deposit(BigDecimal amount) {
      checkNonNegative(amount, "deposit");
      balance = balance.add(amount);
    }

    @Override
    public void withdraw(BigDecimal amount) {
      checkNonNegative(amount, "withdraw");
      balance = balance.subtract(amount);
    }

    @Override
    public BigDecimal balance() {
      return balance;
    }

    private void checkNonNegative(BigDecimal amount, String action) {
      if (amount.signum() == -1) {
        throw new IllegalArgumentException(
            String.format("Cannot %s negative amounts: %s", action, amount));
      }
    }
  }
}
