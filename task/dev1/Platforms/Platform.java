package com.moluram.task.dev1.Platforms;

import com.moluram.task.dev1.Options.Option;

import java.util.List;

/**
 * Represent a platform for program implementation
 */
public class Platform {
  /**
   * List of options for check
   */
  private List<Option> optionList;

  /**
   * Constructor for Platform object
   * @param optionList - List of options for check
   */
  public Platform(List<Option> optionList) {
    this.optionList = optionList;
  }

  /**
   * Checks given arguments for options
   * @param argument - argument for a check
   * @return boolean - answer of a check
   */
  public boolean checkArgument(String argument) {
    for (Option option: optionList) {
      if (option.check(argument)) {
        return true;
      }
    }
    return false;
  }
}
