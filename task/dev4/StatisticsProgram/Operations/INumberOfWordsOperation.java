package com.moluram.task.dev4.StatisticsProgram.Operations;

/**
 * Represent a interface which provides behavior for a class which serves for calculating
 * numbers of words with more than given number letters from text
 */
public interface INumberOfWordsOperation {
  /**
   * Calculates numbers of words with more than given number letters from text
   * @param text - text to check
   * @return int - number of suitable words
   */
  int getCountOfSuitableWords(String text);
}
