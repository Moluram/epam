package com.moluram.task.dev4.StatisticsProgram.Operations;

/**
 * Abstracts implementation of an Operations
 */
public class OperationFactory {
  /**
   * Returns new object of NumberOfWordsOperation
   * @param numberOfNeededLetters - number for a constructor of NumberOfWordsOperation
   * @return INumberOfWordsOperation - returns new object of NumberOfWordsOperation
   */
  public INumberOfWordsOperation getNumberOfWordsOperation(int numberOfNeededLetters) {
    return new NumberOfWordsOperation(numberOfNeededLetters);
  }

  /**
   * Returns new object of TheOccurrenceOfPacksOfLettersOperation
   * @param numberOfLettersForAPack - number for a constructor of
   *                                TheOccurrenceOfPacksOfLettersOperation
   * @return INumberOfWordsOperation - returns new object of TheOccurrenceOfPacksOfLettersOperation
   */
  public ITheOccurrenceOfPacksOfLettersOperation getTheOccurrenceOfPacksOfLettersOperation(
      int numberOfLettersForAPack) {
    return new TheOccurrenceOfPacksOfLettersOperation(numberOfLettersForAPack);
  }

  /**
   * Returns new object of FrequencyCounterOperation
   * @return INumberOfWordsOperation - returns new object of FrequencyCounterOperation
   */
  public IFrequencyCounterOperation getFrequencyCounterOperation() {
    return new FrequencyCounterOperation();
  }
}
