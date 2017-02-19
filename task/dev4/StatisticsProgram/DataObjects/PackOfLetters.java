package com.moluram.task.dev4.StatisticsProgram.DataObjects;

/**
 * Represent a single pack of letters which contains number of occurrence and frequency count for
 * this pack
 */
public class PackOfLetters {
  private final String packOfLetters;

  /**
   * Number of occurrence of this pair in a text
   */
  private int numberOfOccurrence = 1;

  /**
   * Frequency of this pack in a text
   */
  private float frequencyCount = 0;

  /**
   * Simple constructor for a PackOfLetters which sets only a String packOfLetters
   * @param packOfLetters - pack of letters for statistic
   */
  public PackOfLetters(String packOfLetters) {
    this.packOfLetters = packOfLetters;
  }

  /**
   * Gets number of occurrence
   * @return int - number of occurrence
   */
  public int getNumberOfOccurrence() {
    return numberOfOccurrence;
  }

  /**
   * Sets number of occurrence
   * @param numberOfOccurrence - number of occurrence to set
   */
  public void setNumberOfOccurrence(int numberOfOccurrence) {
    this.numberOfOccurrence = numberOfOccurrence;
  }

  /**
   * Increments number of occurrence
   */
  public void numberOfOccurrenceIncrement() {
    numberOfOccurrence++;
  }

  /**
   * Sets frequency count
   * @param frequencyCount - frequency count to set
   */
  public void setFrequencyCount(float frequencyCount) {
    this.frequencyCount = frequencyCount;
  }

  /**
   * Standard equals which compares only String packOfLetters
   * @param o - object to compare
   * @return boolean - answer of the compare
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PackOfLetters that = (PackOfLetters) o;

    return packOfLetters != null ?
        packOfLetters.equals(that.packOfLetters) : that.packOfLetters == null;
  }

  /**
   * Creates hashcode based only of String packOfLetters
   * @return int - hashcode
   */
  @Override
  public int hashCode() {
    return packOfLetters != null ? packOfLetters.hashCode() : 0;
  }

  /**
   * Converts this object to String
   * @return String - String value of this object
   */
  @Override
  public String toString() {
    return packOfLetters + " : " + frequencyCount;
  }
}
