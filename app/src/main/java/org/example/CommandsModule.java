package org.example;

import static org.example.Database.*;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
interface CommandsModule {
  @Binds
  @IntoMap
  @StringKey("hello")
  Command helloWorld(HelloWorldCommand command);

  @Binds
  @IntoMap
  @StringKey("login")
  Command login(LoginCommand command);

  @BindsOptionalOf
  Account loggedInAccount();
}
