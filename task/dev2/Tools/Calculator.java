package com.moluram.task.dev2.Tools;

import com.moluram.task.dev2.Operations.Operation;

import java.math.BigDecimal;
import java.util.*;

/**
 * Represent a calculator that works with an String expressions
 */
public class Calculator {
  private static final String STRING_EMPTY = "";
  private static final String STRING_SPACE = " ";
  private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "Wrong input: ";
  private static final String DEFAULT_VALUE_FOR_BIG_DECIMAL = "0";
  private static final char OPEN_BRACKET = '(';
  private static final char CLOSE_BRACKET = ')';
  private static final char LOWERCASE_E = 'e';
  private static final char UPPERCASE_E = 'E';
  private static final int MAGNIFICATION_OF_A_METRIC_COEFFICIENT = 4;
  private static final int ZERO_FOR_THE_START = 0;
  private static final int ONE_TO_GET_NEXT_ELEMENT = 1;
  private static final int ONE_TO_GET_PREVIOUS_ELEMENT = 1;
  private static final long DEFAULT_METRIC_COEFFICIENT_FOR_VALUES_WITHOUT_BRACKETS = 1;

  /**
   * Represent a list of support operations
   */
  private final List<Operation> operationList;

  /**
   * An expression to solve
   */
  private String expression;

  /**
   * Represent a list of sets which contains operations in priority order
   */
  private List<ItemOperationSet> itemOperationSetList = new LinkedList<>();

  /**
   * List of all numbers in an expression
   */
  private List<BigDecimal> numbersList = new LinkedList<>();

  /**
   * The answer of an expression
   */
  private BigDecimal answer = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);

  /**
   * Main constructor for a calculator
   * @param operationList - list of support operations
   */
  public Calculator(List<Operation> operationList) {
    this.operationList = operationList;
  }

  /**
   * Sets expression and starts the parsing of an expression and solving of the expression
   * @param expression - expression to solve
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  public void setExpression(String expression) throws NumberFormatException {
    this.expression = expression.replaceAll(STRING_SPACE, STRING_EMPTY);
    parseExpression();
    solveExpression();
  }

  /**
   * Returning the answer of an expression
   * @return BigDecimal - the answer of an expression
   */
  public BigDecimal getAnswerToAnExpression() {
    return answer;
  }

  /**
   * Solves the expression
   * Gets operations from itemOperationSetList in a metric order
   */
  private void solveExpression() {
    for (ItemOperationSet itemOperationSet : itemOperationSetList) {
      answer = itemOperationSet.getOperation().solve(
         numbersList.get(itemOperationSet.getNumber()),
         numbersList.get(itemOperationSet.getNumber() + ONE_TO_GET_NEXT_ELEMENT));
      numbersList.remove(itemOperationSet.getNumber());
      numbersList.remove(itemOperationSet.getNumber());
      numbersList.add(itemOperationSet.getNumber(), answer);
      numbersList.add(itemOperationSet.getNumber(), answer);
    }
  }

  /**
   * Parsing expression for the lists
   * Sets metric to each operation for defining their priority
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  private void parseExpression()  throws NumberFormatException{
    long metricCoefficient = DEFAULT_METRIC_COEFFICIENT_FOR_VALUES_WITHOUT_BRACKETS;
    int counterOfNumbers = ZERO_FOR_THE_START;
    int startOfSubString = ZERO_FOR_THE_START;
    int endOfSubstring = ZERO_FOR_THE_START;
    mainLoop:
    for (int i = 0; i < expression.length(); i++) {
      for (Operation operation : operationList) {
        if (operation.isSupport(expression.charAt(i))) {
          if (charIsNotE(expression.charAt(i - ONE_TO_GET_PREVIOUS_ELEMENT))) {
            itemOperationSetList.add(new ItemOperationSet(
                metricCoefficient * operation.coefficient(),
                    counterOfNumbers, operation));
            if (expression.charAt(i - ONE_TO_GET_PREVIOUS_ELEMENT) != CLOSE_BRACKET) {
              createNumber(startOfSubString, endOfSubstring);
            }
            counterOfNumbers++;
            startOfSubString = i + ONE_TO_GET_NEXT_ELEMENT;
            endOfSubstring = i + ONE_TO_GET_NEXT_ELEMENT;
            continue mainLoop;
          }
        }
      }
      if (expression.charAt(i) == OPEN_BRACKET) {
        startOfSubString = i + ONE_TO_GET_NEXT_ELEMENT;
        endOfSubstring = i + ONE_TO_GET_NEXT_ELEMENT;
        if (testCharOnOperations(i + ONE_TO_GET_NEXT_ELEMENT)) {
          i++;
        }
        metricCoefficient *= MAGNIFICATION_OF_A_METRIC_COEFFICIENT;
        continue;
      }
      if (expression.charAt(i) == CLOSE_BRACKET) {
        createNumber(startOfSubString,endOfSubstring);
        metricCoefficient /= MAGNIFICATION_OF_A_METRIC_COEFFICIENT;
        continue;
      }
      endOfSubstring++;
    }
    createNumber(startOfSubString, endOfSubstring);
    itemOperationSetList.sort(new ItemOperationSet.SortByMetric());
    Collections.reverse(itemOperationSetList);
  }

  /**
   * Checks whether the given char is 'e' of 'E'
   * @param c - char for the check
   * @return boolean - answer for the check
   */
  private boolean charIsNotE(char c) {
    return !(c == LOWERCASE_E || c == UPPERCASE_E);
  }

  /**
   * Creates a BigDecimal number from a given substring
   * @param startOfSubString - start of the substring
   * @param endOfSubstring - end of the the substring
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  private void createNumber(int startOfSubString, int endOfSubstring) throws NumberFormatException {
    String substring = expression.substring(startOfSubString, endOfSubstring);
    try {
      numbersList.add(new BigDecimal(substring));
    } catch (NumberFormatException e) {
      throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE + substring);
    }
  }

  /**
   * Tests whether the char is supported by one of the operations
   * @param i - index of char in expression
   * @return boolean - answer for the check
   */
  private boolean testCharOnOperations(int i) {
    for (Operation operation : operationList) {
      if (operation.isSupport(expression.charAt(i))) {
        return true;
      }
    }
    return false;
  }
}
