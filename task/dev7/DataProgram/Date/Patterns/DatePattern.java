package com.moluram.task.dev7.DataProgram.Date.Patterns;

/**
 * Represent an abstract date format pattern
 */
public abstract class DatePattern {
  private final String pattern;

  DatePattern(String PATTERN) {
    this.pattern = PATTERN;
  }

  public String getPattern() {
    return pattern;
  }

  /**
   * Checks whether the given line can be the result of this pattern
   * @param line - line to check
   * @return boolean - answer
   */
  public abstract boolean isSupport(String line);
}
