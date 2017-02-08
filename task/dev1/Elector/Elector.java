package com.moluram.task.dev1.Elector;

import java.util.List;

/**
 * Determines the view of the Elector
 */
public interface Elector {
  /**
   * Main function for the elector
   * Return list of elected items
   * @param listOfItems   - filter elements
   * @param numberOfItems - number of elements to elect
   * @return List - list of elected items
   * @throws NotEnoughItemsException - throws whether the items don't enough for the election
   */
  public List elect(List listOfItems, int numberOfItems) throws NotEnoughItemsException;
}
