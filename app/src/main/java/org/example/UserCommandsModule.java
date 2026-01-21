package org.example;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public interface UserCommandsModule {
  @Binds
  @IntoMap
  @StringKey("deposit")
  Command deposit(DepositCommand command);

  @Binds
  @IntoMap
  @StringKey("withdraw")
  Command withdraw(WithdrawCommand command);

  @Binds
  @IntoMap
  @StringKey("logout")
  Command logout(LogoutCommand command);
}
