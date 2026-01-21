package org.example;

import java.util.List;
import javax.inject.Inject;

final class LogoutCommand implements Command {

  private final Outputter outputter;
  private final Database.Account account;

  @Inject
  LogoutCommand(Outputter outputter, Database.Account account) {
    this.outputter = outputter;
    this.account = account;
  }

  @Override
  public Result handleInput(List<String> input) {
    if (!input.isEmpty()) {
      return Result.invalid();
    }
    outputter.output("logged out " + account.username());
    return Result.inputCompleted();
  }
}
