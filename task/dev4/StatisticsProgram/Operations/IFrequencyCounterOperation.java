package com.moluram.task.dev4.StatisticsProgram.Operations;

import com.moluram.task.dev4.StatisticsProgram.DataObjects.PackOfLetters;

import java.util.List;

/**
 * Represent a interface which provides behavior for a class which serves for calculating
 * frequency for a list of packs
 */
public interface IFrequencyCounterOperation {
  /**
   * Calculates frequency for a list of packs
   * @param packOfLetters - packs for calculates frequency
   * @param numberOfOccurrences - value for calculating frequency. Represents a sum of all
   *                            occurrences of all packs
   * @return List<PackOfLetters> - list of pack with the calculated frequency
   */
  List<PackOfLetters> countOnPacks(List<PackOfLetters> packOfLetters,
                                   long numberOfOccurrences);
}
