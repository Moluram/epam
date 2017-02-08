package com.moluram.task.dev1.Elector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represent an elector which bases on random type of election
 */
public class RandomElector implements Elector {
  /**
   * Randomly elects items from a list
   * Return list of elected items
   * @param listOfItems   - filter elements
   * @param numberOfItems - number of elements to elect
   * @return List - list of elected items
   * @throws NotEnoughItemsException - throws whether the items don't enough for the election
   */
  @Override
  public List elect(List listOfItems, int numberOfItems) throws NotEnoughItemsException {
    if (listOfItems.size() < numberOfItems) {
      throw new NotEnoughItemsException();
    }
    List<Object> newItemsList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < numberOfItems; i++) {
      int randomValue = random.nextInt(listOfItems.size());
      newItemsList.add(listOfItems.get(randomValue));
    }
    return newItemsList;
  }
}
