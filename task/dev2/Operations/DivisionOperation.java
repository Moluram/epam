package com.moluram.task.dev2.Operations;

import java.math.BigDecimal;

/**
 * Represent a division operation
 */
public class DivisionOperation implements Operation {
  private static final char OPERATOR = '/';
  private static final char METRIC_COEFFICIENT = 2;

  /**
   * Performs an action on two operands
   * @param operandA - first operand
   * @param operandB - second operand
   * @return BigDecimal - result of an action
   */
  @Override
  public BigDecimal solve(BigDecimal operandA, BigDecimal operandB) {
    return operandA.divide(operandB, operandA.scale(), BigDecimal.ROUND_HALF_UP);
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
   * Coefficient of an operation for the metric
   * @return long - coefficient
   */
  @Override
  public long coefficient() {
    return METRIC_COEFFICIENT;
  }
}
