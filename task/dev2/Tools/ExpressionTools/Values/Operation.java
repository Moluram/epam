package com.moluram.task.dev2.Tools.ExpressionTools.Values;

import com.moluram.task.dev2.Tools.Operators.Operator;

import java.math.BigDecimal;

/**
 * Represent an Operation with two arguments
 */
public class Operation implements Value {
  /**
   * First operand of operation
   */
  private Value firstValue;

  /**
   * Second operand of operation
   */
  private Value secondValue;

  /**
   * Operator for an operation
   */
  private Operator operator;

  /**
   * Constructor for an object of Operation
   * @param firstValue - First operand of operation
   * @param secondValue - Second operand of operation
   * @param operator - Operator for an operation
   */
  public Operation(Value firstValue, Value secondValue, Operator operator) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
    this.operator = operator;
  }

  /**
   * Returns the result of operation
   * @return BigDecimal - result
   */
  @Override
  public BigDecimal getValue() {
    return operator.solve(firstValue.getValue(), secondValue.getValue());
  }
}
