package com.moluram.task.dev2.Helpers;

import com.moluram.task.dev2.Operations.*;
import com.moluram.task.dev2.Tools.Calculator;

import java.util.LinkedList;
import java.util.List;

/**
 * Serve for executing class Calculator
 */
public class Executor {
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
   * @return List<Operation> - list of operations
   */
  private List<Operation> createListOfOperations() {
    List<Operation> operations = new LinkedList<>();
    operations.add(new AdditionOperation());
    operations.add(new DivisionOperation());
    operations.add(new MultiplicationOperation());
    operations.add(new SubtractionOperation());
    return operations;
  }
}
