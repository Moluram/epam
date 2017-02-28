package com.moluram.task.dev4.StatisticsProgram.Operations;

import com.moluram.task.dev4.StatisticsProgram.DataObjects.PackOfLetters;

import java.util.List;

/**
 * Represent a interface which provides behavior for a class which serves for calculating
 * the occurrences of packs of letters in a text. Pack - some pack of letters where number of
 * letters are set from outside
 */
public interface ITheOccurrenceOfPacksOfLettersOperation {
  /**
   * Checks text for a packs
   * @param text - 
   */
  void checkText(String text);

  /**
   * Returns number of pack of letters in this text
   * @return long - number of pack of letters
   */
  long numberOfPacks();

  /**
   * Returns list of found PacksOfLetters with their occurrences
   * @return List<PackOfLetters> - list of packs of letters
   */
  List<PackOfLetters> getListOfPacksOfLetters();
}
