package org.example;

import dagger.Binds;
import dagger.Module;

@Module
interface InMemoryDatabaseModule {
  @Binds
  Database inMemory(InMemoryDatabase database);
}
