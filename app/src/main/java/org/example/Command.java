package org.example;

import java.util.List;

interface Command {

  String key();

  Result handleInput(List<String> input);

  final class Result {
    private final Status status;

    private Result(Status status) {
      this.status = status;
    }

    static Result invalid() {
      return new Result(Status.INVALID);
    }
  }

  enum Status {
    INVALID,
    HANDLED
  }
}
