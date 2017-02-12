package com.moluram.task.dev2.Tools;

import com.moluram.task.dev2.Tools.Operators.Operator;
import com.moluram.task.dev2.Tools.Parser.ExpressionParser;
import com.moluram.task.dev2.Tools.Values.Value;

import java.math.BigDecimal;
import java.util.*;

/**
 * Represent a calculator that works with an String expressions
 */
public class Calculator {
  private static final String STRING_EMPTY = "";
  private static final String STRING_SPACE = " ";
  private static final String DEFAULT_VALUE_FOR_BIG_DECIMAL = "0";
  private static final int ONE_TO_GET_NEXT_ELEMENT = 1;

  /**
   * Represent a list of support operations
   */
  private final List<Operator> operatorList;

  /**
   * An expression to solve
   */
  private String expression;

  /**
   * The answer of an expression
   */
  private BigDecimal answer = new BigDecimal(DEFAULT_VALUE_FOR_BIG_DECIMAL);

  /**
   * Main constructor for a calculator
   * @param operatorList - list of support operations
   */
  public Calculator(List<Operator> operatorList) {
    this.operatorList = operatorList;
  }

  private ExpressionParser expressionParser;

  /**
   * Sets expression and starts the parsing of an expression and solving of the expression
   * @param expression - expression to solve
   * @throws NumberFormatException - throws whether the expression contains non supported symbols
   */
  public void setExpression(String expression) throws NumberFormatException {
    this.expression = expression.replaceAll(STRING_SPACE, STRING_EMPTY);
    expressionParser = new ExpressionParser(this.expression, operatorList);
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
   */
  private void solveExpression() {
    answer = expressionParser.getExpression().getValue();
  }
}
