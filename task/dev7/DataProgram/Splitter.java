package com.moluram.task.dev7.DataProgram;

import java.util.List;

/**
 * Class for splitting strings
 */
class Splitter {
  private static final Character OPEN_BRACKET = '[';
  private static final Character CLOSE_BRACKET = ']';
  private static final Character OR_SYMBOL = '|';

  /**
   * Splits given string with given separators
   * @param line - line to split
   * @param separatorsList - separators to use
   * @return String[] - result array
   */
  String[] splitLineBySeparators(String line, List<Character> separatorsList) {
    StringBuilder lineOfSeparators = new StringBuilder();
    lineOfSeparators.append(OPEN_BRACKET);
    for (Character separator: separatorsList) {
      lineOfSeparators.append(separator).append(OR_SYMBOL);
    }
    lineOfSeparators.append(CLOSE_BRACKET);
    return line.split(lineOfSeparators.toString());
  }
}
