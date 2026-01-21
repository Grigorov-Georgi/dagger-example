package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CommandLineAtm {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {

      CommandProcessor commandProcessor = CommandProcessorFactory.create().commandProcessor();

      while (scanner.hasNextLine()) {
        Command.Status commandStatus = commandProcessor.process(scanner.nextLine());
        if (commandStatus.equals(Command.Status.INPUT_COMPLETED)) {
          break;
        }
      }
    } finally {
      System.out.println("problem, problem");
    }
  }
}
