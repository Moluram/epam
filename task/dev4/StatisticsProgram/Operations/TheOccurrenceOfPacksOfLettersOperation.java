package com.moluram.task.dev4.StatisticsProgram.Operations;

import com.moluram.task.dev4.StatisticsProgram.DataObjects.PackOfLetters;

import java.util.LinkedList;
import java.util.List;

/**
 * Class serves for calculating the occurrences of packs of letters in a text. Pack - some pack
 * of letters where number of letters are set from outside
 */
class TheOccurrenceOfPacksOfLettersOperation implements ITheOccurrenceOfPacksOfLettersOperation {
  private static final String SPACE = " ";
  private static final int NOT_FOUND = -1;

  /**
   * Number of letters for a pack
   */
  private final int numberOfLettersForAPack;

  /**
   * Text to check
   */
  private String text;

  /**
   * Final number of packs in a text
   */
  private long numberOfPacks = 0;

  /**
   * List of existing packs in the given text
   */
  private List<PackOfLetters> packOfLettersList;

  /**
   * Simple constructor for a TheOccurrenceOfPacksOfLettersOperation
   * @param numberOfLettersForAPack - number of letters for a pack
   */
  TheOccurrenceOfPacksOfLettersOperation(int numberOfLettersForAPack) {
    this.numberOfLettersForAPack = numberOfLettersForAPack;
  }

  /**
   * Checks text for a packs
   * @param text -
   */
  @Override
  public void checkText(String text) {
    this.text = text;
    parseTextIntoPacks();
  }

  /**
   * Parses text into text pairs
   */
  private void parseTextIntoPacks() {
    packOfLettersList = new LinkedList<>();
    numberOfPacks = 0;
    for (String word: text.split(SPACE)) {
      int startOfSubstring = 0;
      int endOfSubstring = numberOfLettersForAPack;
      while (endOfSubstring < word.length()) {
        PackOfLetters packOfLetters = new PackOfLetters(word.substring(startOfSubstring++,
            endOfSubstring++));
        int numberOfPack = packOfLettersList.indexOf(packOfLetters);
        if (numberOfPack == NOT_FOUND) {
          packOfLettersList.add(packOfLetters);
          numberOfPacks++;
        } else {
          packOfLettersList.get(numberOfPack).numberOfOccurrenceIncrement();
        }
      }
    }
  }

  /**
   * Returns number of pack of letters in this text
   * @return long - number of pack of letters
   */
  @Override
  public long numberOfPacks() {
    return numberOfPacks;
  }

  /**
   * Returns list of found PacksOfLetters with their occurrences
   * @return List<PackOfLetters> - list of packs of letters
   */
  @Override
  public List<PackOfLetters> getListOfPacksOfLetters() {
    return packOfLettersList;
  }
}
