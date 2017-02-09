package com.moluram.task.dev1.Elector;

import com.moluram.task.dev1.Platforms.Platform;
import com.moluram.task.dev1.Randomizer.ListRandomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represent an elector which bases on a random type of election
 */
public class RandomElector {
  private static final String MESSAGE_NOT_ENOUGH_ITEMS_EXCEPTION = "Not enough items for election!";
  private static final String MESSAGE_NEGATIVE_NUMBER_OF_ITEMS =
      "Negative number of items to elect!";
  private static final int START_OF_THE_LIST = 0;

  /**
   * Target platform for a check
   */
  private Platform platform;

  /**
   * Simple setter for a platform
   * @param platform - target platform
   */
  public void setPlatform(Platform platform) {
    this.platform = platform;
  }

  /**
   * Constructor for a simple object of RandomElector that accepts target platform
   * @param platform - target platform
   */
  public RandomElector(Platform platform) {
    this.platform = platform;
  }

  /**
   * Randomly elects items from an array
   * Return list of elected items
   *
   * @param arrayOfItems - elements to filter
   * @param numberOfItems - number of elements to elect
   * @return List - list of elected items
   * @throws IllegalArgumentException - whether the number of items is more than items in a list
   *                                  or the number of items to return is negative number
   */
  public List elect(String[] arrayOfItems, int numberOfItems) {
    if (arrayOfItems.length < numberOfItems) {
      throw new IllegalArgumentException(MESSAGE_NOT_ENOUGH_ITEMS_EXCEPTION);
    }
    if (numberOfItems < 0) {
      throw new IllegalArgumentException(MESSAGE_NEGATIVE_NUMBER_OF_ITEMS);
    }
    List<Object> tempItemsList = checkListOfItems(arrayOfItems);
    List<Object> newItemsList = new ListRandomizer().random(tempItemsList);
    if (newItemsList.size() < numberOfItems) {
      numberOfItems = newItemsList.size();
    }
    return newItemsList.subList(START_OF_THE_LIST, numberOfItems);
  }

  /**
   * Check which items in given arrat are valid
   * @param arrayOfItems - array of items to check
   * @return List<Object> - list of valid items
   */
  private List<Object> checkListOfItems(String[] arrayOfItems) {
    List<Object> tempItemsList = new ArrayList<>();
    for (String argument: arrayOfItems) {
      if (platform.checkArgument(argument)) {
        tempItemsList.add(argument);
      }
    }
    return tempItemsList;
  }
}
