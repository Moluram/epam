package com.moluram.task.dev2.Tools.ExpressionTools;

import com.moluram.task.dev2.Tools.Operators.Operator;

import java.util.Comparator;

/**
 * Represent a work set for an Calculator
 */
class ItemOperationSet {
  /**
   * Operator for an item
   */
  private Operator operator;

  /**
   * Position of a values for an operator in a list
   */
  private int number;

  /**
   * Metric for sort sets in a list
   */
  private Long metric;

  /**
   * Main constructor for a class ItemOperationSet
   * @param metric - Metric for sort sets in a list
   * @param number - Position of a values for an operator in a list
   * @param operator - Operator for an item
   */
  public ItemOperationSet(long metric, int number, Operator operator) {
    this.number = number;
    this.operator = operator;
    this.metric = metric;
  }

  /**
   * Comparator for a list to sort
   */
  public static class SortByMetric implements Comparator<ItemOperationSet>  {
    @Override
    public int compare(ItemOperationSet a, ItemOperationSet b)
    {
      return a.metric.compareTo(b.metric);
    }
  }

  /**
   * Getter for an operator
   * @return Operator
   */
  public Operator getOperator() {
    return operator;
  }

  /**
   * Getter for a number
   * @return int
   */
  public int getNumber() {
    return number;
  }
}
