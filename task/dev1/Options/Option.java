package com.moluram.task.dev1.Options;

/**
 * An interface for an everyone whom wants to be an Option class
 * Serves for checking given vales
 */
public interface Option {
  /**
   * Checks given value
   * @param value - value for a check
   * @return boolean - answer of a check
   */
  boolean check(String value);
}
