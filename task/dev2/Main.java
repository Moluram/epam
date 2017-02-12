package com.moluram.task.dev2;

import com.moluram.task.dev2.Helpers.Executor;
import com.moluram.task.dev2.Tools.Calculator;

import java.util.Scanner;

/**
 * Serve for executing the program
 */
public class Main {
  private static final String EMPTY_STRING = "";
  private static final int EMPTY_ARRAY = 0;
  private static final String AWAITING_INPUT_MESSAGE = "Awaiting input :";

  /**
   * Executes the class Executor
   * @param args - arguments from a command line
   */
  public static void main(String[] args) {
    String expression = getExpression(args);
    Executor executor = new Executor();
    executor.executeCalculatorWithExpression(expression);
  }

  /**
   * Gets an expression from a command line or console
   * @param args - arguments from a command line
   * @return String - expression from output
   */
  private static String getExpression(String[] args) {
    String expression = EMPTY_STRING;
    if (args.length == EMPTY_ARRAY) {
      Scanner scanner = new Scanner(System.in);
      System.out.println(AWAITING_INPUT_MESSAGE);
      if (scanner.hasNext()) {
        expression += scanner.nextLine();
      }
    } else {
      for (String arg: args) {
        expression += arg;
      }
    }
    return expression;
  }
}
