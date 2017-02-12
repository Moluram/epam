package com.moluram.task.dev2;

import com.moluram.task.dev2.Tools.Operators.*;
import com.moluram.task.dev2.Tools.Calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Serve for executing the program
 */
public class Main {
  private static final String EMPTY_STRING = "";
  private static final int EMPTY_ARRAY = 0;
  private static final String AWAITING_INPUT_MESSAGE = "Awaiting input :";
  private static final int ACCURACY_OF_CALCULATIONS = 250;

  /**
   * Executes the class Executor
   * @param args - arguments from a command line
   */
  public static void main(String[] args) {
    Main main = new Main();
    String expression = main.getExpression(args);
    main.executeCalculatorWithExpression(expression);
  }

  /**
   * Executes class calculator
   * @param expression - expression for the calculator
   */
  public void executeCalculatorWithExpression(String expression) {
    System.out.println(expression);
    try {
      Calculator calculator = new Calculator(createListOfOperations());
      calculator.setExpression(expression);
      System.out.println(calculator.getAnswerToAnExpression());
    } catch (NumberFormatException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates list of operations for calculator
   * @return List<Operator> - list of operations
   */
  private List<Operator> createListOfOperations() {
    List<Operator> operators = new LinkedList<>();
    operators.add(new AdditionOperator());
    operators.add(new DivisionOperator(ACCURACY_OF_CALCULATIONS));
    operators.add(new MultiplicationOperator());
    operators.add(new SubtractionOperator());
    return operators;
  }

  /**
   * Gets an expression from a command line or console
   * @param args - arguments from a command line
   * @return String - expression from output
   */
  private String getExpression(String[] args) {
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
