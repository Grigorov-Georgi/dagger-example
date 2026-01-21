package org.example;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(
    modules = {
      CommandsModule.class,
      InMemoryDatabaseModule.class,
      UserCommandsRouter.InstallationModule.class,
      SystemOutModule.class
    })
interface CommandProcessorFactory {
  CommandProcessor commandProcessor();

  static CommandProcessorFactory create() {
    return DaggerCommandProcessorFactory.create();
  }
}
