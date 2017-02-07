package com.moluram.task.dev1.Printer;

import java.util.List;

/**
 * Represent a printer which prints to the console
 */
public class ConsolePrinter implements Printer {
  /**
   * Prints items to the console
   *
   * @param list - list of printed items
   */
  @Override
  public void printList(List list) {
    if (list == null) {
      throw new NullPointerException();
    }
    for (Object object : list) {
      System.out.println(object);
    }
  }

  /**
   * Prints item to the console
   *
   * @param object - printed item
   */
  @Override
  public void print(Object object) {
    if (object == null) {
      throw new NullPointerException();
    }
    System.out.println(object);
  }
}
