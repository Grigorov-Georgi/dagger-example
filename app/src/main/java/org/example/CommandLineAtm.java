package org.example;

import java.util.Scanner;
import org.example.Command.Result;

public class CommandLineAtm {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {

      CommandRouter commandRouter = new CommandRouter();

      while (scanner.hasNextLine()) {
        Result unused = commandRouter.route(scanner.nextLine());
      }
    } finally {
      System.out.println("problem, problem");
    }
  }
}
