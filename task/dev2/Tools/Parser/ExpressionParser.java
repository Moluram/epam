package com.moluram.task.dev2.Tools.Parser;

import com.moluram.task.dev2.Tools.Operators.Operator;
import com.moluram.task.dev2.Tools.ItemOperationSet;
import com.moluram.task.dev2.Tools.Values.Number;
import com.moluram.task.dev2.Tools.Values.Operation;
import com.moluram.task.dev2.Tools.Values.Value;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Moluram on 12.02.2017.
 */
public class ExpressionParser {
  private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "Wrong input: ";
  private static final char OPEN_BRACKET = '(';
  private static final char CLOSE_BRACKET = ')';
  private static final String LOWERCASE_E = "e";
  private static final int MAGNIFICATION_OF_A_METRIC_COEFFICIENT = 4;
  private static final int ZERO_FOR_THE_START = 0;
  private static final int ONE_TO_GET_NEXT_ELEMENT = 1;
  private static final int ONE_TO_GET_PREVIOUS_ELEMENT = 1;
  private static final long DEFAULT_METRIC_COEFFICIENT_FOR_VALUES_WITHOUT_BRACKETS = 1;

  /**
   * Metric coefficient for an operation
   */
  private long metricCoefficient = DEFAULT_METRIC_COEFFICIENT_FOR_VALUES_WITHOUT_BRACKETS;

  /**
   * Counter of existing numbers
   */
  private int counterOfNumbers = ZERO_FOR_THE_START;

  /**
   * Used for calculating substring with number
   */
  private int startOfSubString = ZERO_FOR_THE_START;
  private int endOfSubstring = ZERO_FOR_THE_START;

  /**
   * Represent a list of support operations
   */
  private List<Operator> operators;

  /**
   * An expression to solve
   */
  private String stringExpression;

  /**
   * Represent a list of sets which contains operations in priority order
   */
  private List<ItemOperationSet> itemOperationSetList = new LinkedList<>();

  /**
   * List of all numbers in an expression
   */
  private List<BigDecimal> numbersList = new LinkedList<>();

  /**
   * List of all numbers in an expression
   */
  private List<Value> values = new LinkedList<>();

  /**
   * Represent the last operation in expression
   */
  private Value expression;

  public List<ItemOperationSet> getItemOperationSets() {
    return itemOperationSetList;
  }

  public List<BigDecimal> getNumberList() {
    return numbersList;
  }

  public List<Value> getListOfValues() {
    return values;
  }

  public Value getExpression() {
    return expression;
  }

  /**
   * Constructor which starts the parsing of an expression
   * @param expression - expression to parse
   * @param operators - operators to use in parsing
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  public ExpressionParser(String expression, List<Operator> operators)
      throws NumberFormatException {
    this.stringExpression = expression;
    this.operators = operators;
    parseExpression();
    sortListOfOperators();
    createAListOfValues();
  }

  /**
   * Creates a list of values which represents an expression
   */
  private void createAListOfValues() {
    List<Value> values = createListOfNumber();
    for (ItemOperationSet itemOperationSet : itemOperationSetList) {
      expression = new Operation(values.get(itemOperationSet.getNumber()),
          values.get(itemOperationSet.getNumber() + ONE_TO_GET_NEXT_ELEMENT),
          itemOperationSet.getOperator());
      values.remove(itemOperationSet.getNumber());
      values.remove(itemOperationSet.getNumber());
      values.add(itemOperationSet.getNumber(), expression);
      values.add(itemOperationSet.getNumber(), expression);
    }
    this.values = values;
  }

  /**
   * Creates a list of numbers in an expression
   * @return List<Value> - list of numbers in an expression
   */
  private List<Value> createListOfNumber() {
    List<Value> listOfNumbers = new LinkedList<>();
    for (BigDecimal bigDecimal: numbersList) {
      listOfNumbers.add(new Number(bigDecimal));
    }
    return listOfNumbers;
  }

  private void sortListOfOperators() {
    itemOperationSetList.sort(new ItemOperationSet.SortByMetric());
    Collections.reverse(itemOperationSetList);
  }

  /**
   * Parses expression into two lists :
   *   * 1st with a numbers
   *   * 2nd with ItemOperationSet which represents a set with metric , operation and number of
   *     item 1st list
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  private void parseExpression() throws NumberFormatException {
    metricCoefficient = DEFAULT_METRIC_COEFFICIENT_FOR_VALUES_WITHOUT_BRACKETS;
    counterOfNumbers = ZERO_FOR_THE_START;
    startOfSubString = ZERO_FOR_THE_START;
    endOfSubstring = ZERO_FOR_THE_START;

    for (int i = 0; i < stringExpression.length(); i++) {
      Operator operator = getOperator(stringExpression.charAt(i));
      if (operator != null && previousCharIsNotE(
          stringExpression.charAt(i - ONE_TO_GET_PREVIOUS_ELEMENT))) {
        addNewOperatorToTheList(operator);
        createNumber(startOfSubString, endOfSubstring);
        movePointerOfSubstringOnwards(i);
        continue;
      }
      if (stringExpression.charAt(i) == OPEN_BRACKET) {
        movePointerOfSubstringOnwards(i);
        if (nextCharIsOperator(stringExpression.charAt(i + ONE_TO_GET_NEXT_ELEMENT))) {
          i++;
        }
        metricCoefficient *= MAGNIFICATION_OF_A_METRIC_COEFFICIENT;
        continue;
      }
      if (stringExpression.charAt(i) == CLOSE_BRACKET) {
        createNumber(startOfSubString, endOfSubstring);
        metricCoefficient /= MAGNIFICATION_OF_A_METRIC_COEFFICIENT;
        continue;
      }
      endOfSubstring++;
    }
    createNumber(startOfSubString, endOfSubstring);
  }

  /**
   * Creates a single number from a substring
   * @param startOfSubString - start of the substring
   * @param endOfSubstring - end of the substring
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  private void createNumber(int startOfSubString, int endOfSubstring) throws NumberFormatException {
    String substring = stringExpression.substring(startOfSubString, endOfSubstring);
    try {
      numbersList.add(new BigDecimal(substring));
    } catch (NumberFormatException e) {
      throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE + substring);
    }
    counterOfNumbers++;
  }

  /**
   * Checks whether the next character is operator
   * @param character - character to check
   * @return boolean - answer
   */
  private boolean nextCharIsOperator(char character) {
    for (Operator operator : operators) {
      if (operator.isSupport(character)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Moves pointer of substring to nex symbol
   * @param i - current location
   */
  private void movePointerOfSubstringOnwards(int i) {
    startOfSubString = i + ONE_TO_GET_NEXT_ELEMENT;
    endOfSubstring = i + ONE_TO_GET_NEXT_ELEMENT;
  }

  /**
   * Creates and add new operator to a list
   * @param operator - operator to create
   */
  private void addNewOperatorToTheList(Operator operator) {
    itemOperationSetList.add(new ItemOperationSet(metricCoefficient * operator.coefficient(),
        counterOfNumbers, operator));
  }

  /**
   * Checks whether the previous character is e for an expression with smth like this : 2e+2
   * @param character - character to check
   * @return boolean - answer
   */
  private boolean previousCharIsNotE(Character character) {
    return !(character.toString().toLowerCase().equals(LOWERCASE_E));
  }

  /**
   * Returns an operator that supporting given character
   * @param character - character for an operator
   * @return Operator - found operator
   */
  private Operator getOperator(char character) {
    for (Operator operator : operators) {
      if (operator.isSupport(character)) {
        return operator;
      }
    }
    return null;
  }
}
