package com.moluram.task.dev4.StatisticsProgram.Operations;

/**
 * Class serves for calculating numbers of words with more than given number letters from text
 */
class NumberOfWordsOperation implements INumberOfWordsOperation {
  private static final String SPACE = " ";

  /**
   * Min number of letters for a suitable words
   */
  private final int numberOfLetters;

  /**
   * Simple constructor for a NumberOfWordsOperation
   * @param numberOfNeededLetters - min number of letters for a suitable words
   */
  NumberOfWordsOperation(int numberOfNeededLetters) {
    this.numberOfLetters = numberOfNeededLetters;
  }

  /**
   * Calculates numbers of words with more than given number letters from text
   * @param text - text to check
   * @return int - number of suitable words
   */
  @Override
  public int getCountOfSuitableWords(String text) {
    int numberOfNeededWords = 0;
    for (String word: text.split(SPACE)) {
      if (word.length() >= numberOfLetters) {
        numberOfNeededWords++;
      }
    }
    return numberOfNeededWords;
  }
}
