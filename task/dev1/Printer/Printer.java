package com.moluram.task.dev1.Printer;

import java.util.List;

/**
 * Determines the view of the Printer
 */
public interface Printer {
  /**
   * Prints items to the console
   *
   * @param list - list of printed items
   */
  public void printList(List list);

  /**
   * Prints item to the console
   *
   * @param object - printed item
   */
  public void print(Object object);
}
