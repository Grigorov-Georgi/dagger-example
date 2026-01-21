package org.example;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@PerSession
@Subcomponent(modules = {AccountModule.class, AmountsModule.class, UserCommandsModule.class})
public interface UserCommandsRouter {
  CommandRouter router();

  @Subcomponent.Factory
  interface Factory {
    UserCommandsRouter create(@BindsInstance @Username String username);
  }

  @Module(subcomponents = UserCommandsRouter.class)
  interface InstallationModule {}
}
