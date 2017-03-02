package com.moluram.task.dev5.Finder.InputOutput;

import java.util.Scanner;

/**
 * Provides access to the console
 */
public class ConsoleIO implements IInputOutput {
  /**
   * Object for getting input from console
   */
  private final Scanner scanner = new Scanner(System.in);

  /**
   * Gets new line from the input
   * @return String - line from a console
   */
  @Override
  public String getNextLine() {
    return scanner.nextLine();
  }

  /**
   * Prints line to the console
   * @param line - line to print
   */
  @Override
  public void printLine(String line) {
    System.out.println(line);
  }
}
