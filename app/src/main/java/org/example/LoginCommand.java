package org.example;

import java.util.Optional;
import javax.inject.Inject;

final class LoginCommand extends SingleArgCommand {
  private final Outputter outputter;
  private final Optional<Database.Account> account;
  private final UserCommandsRouter.Factory userCommandsFactory;

  @Inject
  LoginCommand(
      Outputter outputter,
      Optional<Database.Account> account,
      UserCommandsRouter.Factory userCommandsFactory) {
    this.outputter = outputter;
    this.account = account;
    this.userCommandsFactory = userCommandsFactory;
  }

  @Override
  public Command.Result handleArg(String username) {
    if (account.isPresent()) {
      String loggedInUser = account.get().username();
      outputter.output(loggedInUser + " is already logged in");
      if (!loggedInUser.equals(username)) {
        outputter.output("run `logout` first before trying to log in another user");
      }
      return Command.Result.handled();
    } else {
      UserCommandsRouter userCommands = userCommandsFactory.create(username);
      return Command.Result.enterNestedCommandSet(userCommands.router());
    }
  }
}
