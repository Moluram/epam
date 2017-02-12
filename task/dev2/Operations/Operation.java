package com.moluram.task.dev2.Operations;

import java.math.BigDecimal;

/**
 * Represent a single mathematical operation
 */
public interface Operation {
  /**
   * Performs an action on two operands
   * @param operandA - first operand
   * @param operandB - second operand
   * @return BigDecimal - result of an action
   */
  BigDecimal solve(BigDecimal operandA, BigDecimal operandB);

  /**
   * Looks whether the given symbol is this opetaion
   * @param c - param to compare
   * @return boolean - the answer
   */
  boolean isSupport(char c);

  /**
   * Coefficient of an operation for the metric
   * @return long - coefficient
   */
  long coefficient();
}
