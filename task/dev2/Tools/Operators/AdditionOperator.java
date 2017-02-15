package com.moluram.task.dev2.Tools.Operators;

import java.math.BigDecimal;

/**
 * Represent an addition operation
 */
public class AdditionOperator implements Operator {
  private static final char OPERATOR = '+';
  private static final int METRIC_COEFFICIENT = 1;

  /**
   * Performs an action on two operands
   * @param operandA - first operand
   * @param operandB - second operand
   * @return BigDecimal - result of an action
   */
  @Override
  public BigDecimal solve(BigDecimal operandA, BigDecimal operandB) {
    return operandA.add(operandB);
  }

  /**
   * Looks whether the given symbol is this opetaion
   * @param c - param to compare
   * @return boolean - the answer
   */
  @Override
  public boolean isSupport(char c) {
    return c == OPERATOR;
  }

  /**
   * Priority coefficient of an operation for the metric
   * @return long - coefficient
   */
  @Override
  public long coefficient() {
    return METRIC_COEFFICIENT;
  }
}
