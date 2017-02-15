package com.moluram.task.dev1.Helpers;

import com.moluram.task.dev1.Elector.RandomElector;
import com.moluram.task.dev1.Options.Option;
import com.moluram.task.dev1.Options.SingleMinusOption;
import com.moluram.task.dev1.Options.SlashOption;
import com.moluram.task.dev1.Options.TwoMinusOption;
import com.moluram.task.dev1.Platforms.Platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Serve for executing class RandomElector
 */
public class Executor {
  private static final int NUMBER_OF_ITEMS_TO_ELECT = 3;

  /**
   * Execute RandomElector
   *
   * @param testItems - items which sends to the exemplar of a RandomElector class
   */
  public void executeElector(String[] testItems) {
    Arrays.asList(testItems);
    RandomElector elector = new RandomElector(createLinuxPlatform());
    try {
      for (Object object : elector
          .elect(testItems, NUMBER_OF_ITEMS_TO_ELECT)) {
        System.out.println(object);
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Create a linux target platform
   * @return Platform - linux target platform
   */
  private Platform createLinuxPlatform() {
    return new Platform(createListOfOptionsForLinux());
  }

  /**
   * Create a list of options for a linux
   * @return List<Option> - list of options for a linux
   */
  private List<Option> createListOfOptionsForLinux() {
    List<Option> optionList = new ArrayList<>();
    optionList.add(new SingleMinusOption());
    optionList.add(new TwoMinusOption());
    return optionList;
  }
}
