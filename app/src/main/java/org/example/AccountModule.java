package org.example;

import dagger.Module;
import dagger.Provides;
import org.example.Database.Account;

// The following annotation properly applies @Module to a class, not an interface
@Module
interface AccountModule {
  @Provides
  static Account account(Database database, @Username String username) {
    return database.getAccount(username);
  }
}
