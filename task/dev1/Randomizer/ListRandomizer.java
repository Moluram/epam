package com.moluram.task.dev1.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represent a simple randomizer for a list of objects
 */
public class ListRandomizer {
  /**
   * Randomize list of Object
   * @param tempItemsList - list to randomize
   * @return List<Object> - randomized list
   */
  public List<Object> random(List<Object> tempItemsList) {
    List<Object> newItemsList = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < tempItemsList.size(); i++) {
      int randomValue = random.nextInt(tempItemsList.size());
      newItemsList.add(tempItemsList.get(randomValue));
      tempItemsList.remove(randomValue);
    }
    return newItemsList;
  }
}
