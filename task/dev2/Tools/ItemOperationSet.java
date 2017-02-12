package com.moluram.task.dev2.Tools;

import com.moluram.task.dev2.Operations.Operation;

import java.util.Comparator;

/**
 * Represent a work set for an Calculator
 */
class ItemOperationSet {
  /**
   * Operation for an item
   */
  private Operation operation;

  /**
   * Position of a values for an operation in a list
   */
  private int number;

  /**
   * Metric for sort sets in a list
   */
  private Long metric;

  /**
   * Main constructor for a class ItemOperationSet
   * @param metric - Metric for sort sets in a list
   * @param number - Position of a values for an operation in a list
   * @param operation - Operation for an item
   */
  ItemOperationSet(long metric, int number, Operation operation) {
    this.number = number;
    this.operation = operation;
    this.metric = metric;
  }

  /**
   * Comparator for a list to sort
   */
  static class SortByMetric implements Comparator<ItemOperationSet>
  {
    @Override
    public int compare(ItemOperationSet a, ItemOperationSet b)
    {
      return a.metric.compareTo(b.metric);
    }

  }

  /**
   * Getter for an operation
   * @return Operation
   */
  Operation getOperation() {
    return operation;
  }

  /**
   * Getter for a number
   * @return int
   */
  int getNumber() {
    return number;
  }
}
