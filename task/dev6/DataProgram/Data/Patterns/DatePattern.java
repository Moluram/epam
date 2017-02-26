package com.moluram.task.dev6.DataProgram.Data.Patterns;

/**
 * Represent an abstract date format pattern
 */
public abstract class DatePattern implements Comparable {
  private final String pattern;

  /**
   * Priority of pattern in execution
   */
  private final int priority;

  public DatePattern(String PATTERN) {
    this.pattern = PATTERN;
    this.priority = pattern.length();
  }

  public String getPattern() {
    return pattern;
  }

  /**
   * Returns result of the pattern
   * @return String - result
   */
  public abstract String getResult();

  /**
   * Comparing date patterns by priority
   * @param o - object to compare
   * @return int - answer :
   *              1 - if bigger;
   *              0 - if equal;
   *              -1 - less;
   */
  @Override
  public int compareTo(Object o) {
    DatePattern entry = (DatePattern) o;
    return priority > entry.priority ? -1 : priority == entry.priority ? 0 : 1;
  }
}
