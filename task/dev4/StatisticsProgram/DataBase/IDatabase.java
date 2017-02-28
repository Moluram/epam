package com.moluram.task.dev4.StatisticsProgram.DataBase;

import com.moluram.task.dev4.StatisticsProgram.DataObjects.PackOfLetters;

import java.util.List;

/**
 * Provides database behavior
 */
public interface IDatabase {
  /**
   * Adds list to the database
   * @param lettersList - list to add
   */
  void setPackOfLettersList(List<PackOfLetters> lettersList);

  /**
   * Returns list with all packs
   * @return List<PackOfLetters> - list with packs
   */
  List<PackOfLetters> getPackOfLettersList();
}
