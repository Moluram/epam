package com.moluram.task.dev2.Tools.ExpressionTools.Values;

import java.math.BigDecimal;

/**
 * Represent a BigDecimal number
 */
public class Number implements Value {
  /**
   * Storing value
   */
  private BigDecimal number;

  public Number(BigDecimal number) {
    this.number = number;
  }

  @Override
  public BigDecimal getValue() {
    return number;
  }
}
