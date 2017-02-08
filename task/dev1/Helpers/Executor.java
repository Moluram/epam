package com.moluram.task.dev1.Helpers;

import com.moluram.task.dev1.Elector.RandomElector;

import java.util.List;

/**
 * Serve for executing class RandomElector
 */
public class Executor {
  private static final int NUMBER_OF_ITEMS_TO_ELECT = 3;

  private static final String MESSAGE_NOT_ENOUGH_ITEMS_EXCEPTION = "Not enough items for election!";
  private static final String MESSAGE_NEGATIVE_NUMBER_OF_ITEMS =
      "Negative number of items to elect!";

  /**
   * Execute RandomElector
   * @param testItems - items which sends to the exemplar of a RandomElector class
   */
  public void executeElector(String[] testItems) {
    RandomElector elector = new RandomElector();
    try {
      for (Object object : elector.elect(testItems, NUMBER_OF_ITEMS_TO_ELECT)) {
        System.out.println(object);
      }
    } catch (NegativeArraySizeException e) {
      System.out.println(MESSAGE_NOT_ENOUGH_ITEMS_EXCEPTION);
    } catch (NumberFormatException e) {
      System.out.println(MESSAGE_NEGATIVE_NUMBER_OF_ITEMS);
    }
  }
}
