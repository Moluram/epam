package com.moluram.task.dev4.StatisticsProgram.DataBase;

import com.moluram.task.dev4.StatisticsProgram.DataObjects.PackOfLetters;

import java.util.LinkedList;
import java.util.List;

/**
 * Class serves for emulating working database
 */
public class FakeDatabase implements IDatabase {
  /**
   * List of existing packs
   */
  private List<PackOfLetters> packOfLettersList = new LinkedList<>();

  /**
   *  Sets new List to the database
   * @param packOfLettersList - list to set
   */
  public void setPackOfLettersList(List<PackOfLetters> packOfLettersList) {
    this.packOfLettersList = packOfLettersList;
  }

  /**
   * Returns list of letters
   * @return List<PackOfLetters> - list of letters
   */
  public List<PackOfLetters> getPackOfLettersList() {
    return packOfLettersList;
  }
}
