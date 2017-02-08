package com.moluram.task.dev1.Tester;

import com.moluram.task.dev1.Elector.Elector;
import com.moluram.task.dev1.Elector.NotEnoughItemsException;
import com.moluram.task.dev1.Elector.RandomElector;
import com.moluram.task.dev1.Printer.ConsolePrinter;
import com.moluram.task.dev1.Printer.Printer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Serve for testing class RandomElector and ConsolePrinter
 */
public class Tester<T> {
  private static final int NUMBER_OF_ITEMS_TO_ELECT = 3;
  private static final String MESSAGE_NOT_ENOUGH_ITEMS_EXCEPTION = "Not enough items for election!";

  /**
   * Execute RandomElector and ConsolePrinter
   * @param testItems - items which sends to the elector
   */
  public void testElector(T[] testItems) {
    Elector elector = new RandomElector();
    Printer printer = new ConsolePrinter();
    try {
      printer.printList(elector
              .elect(new ArrayList<>(Arrays.asList(testItems)), NUMBER_OF_ITEMS_TO_ELECT));
    } catch (NotEnoughItemsException e) {
      printer.print(MESSAGE_NOT_ENOUGH_ITEMS_EXCEPTION);
    }
  }
}
