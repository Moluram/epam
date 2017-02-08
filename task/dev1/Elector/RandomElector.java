package com.moluram.task.dev1.Elector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represent an elector which bases on a random type of election
 */
public class RandomElector {
  /**
   * Randomly elects items from an array
   * Return list of elected items
   * @param listOfItems - elements to filter
   * @param numberOfItems - number of elements to elect
   * @return List - list of elected items
   */
  public List elect(String[] listOfItems, int numberOfItems) {
    if (listOfItems.length < numberOfItems) {
      throw new NegativeArraySizeException();
    }
    if (numberOfItems < 0) {
      throw new NumberFormatException();
    }
    List<Object> newItemsList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < numberOfItems; i++) {
      int randomValue = random.nextInt(listOfItems.length);
      newItemsList.add(listOfItems[randomValue]);
    }
    return newItemsList;
  }
}
