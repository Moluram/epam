package com.moluram.task.dev9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Moluram on 03.03.2017.
 */
public class ParameterReader {
  private static final char CLOSE_BRACKET = ']';
  private static final char OPEN_BRACKET = '[';
  private static final String EQUALITY_SIGN = "=";
  private static final int NOT_KEY = 1;

  /**
   * Gets value of given key in section in the file with given path
   * @param filePath - file path
   * @param section - section of the key
   * @param key - key to fin
   * @return String - value of the key
   * @throws FileNotFoundException - throws whether the given file does not exists
   */
  public String getValueOfParameter(String filePath, String section, String key)
      throws FileNotFoundException {
    section = createSection(section);
    key += EQUALITY_SIGN;
    String value = null;
    FileReader file = new FileReader(filePath);
    try (Scanner scanner = new Scanner(file);) {
      if (findSection(scanner, section)) {
        value = findValue(scanner, key);
      }
    }
    return value;
  }

  /**
   * Finds the key value
   * If not found returns null
   * @param scanner - scanner of the file
   * @param key - key to find
   * @return String - key value
   */
  private String findValue(Scanner scanner, String key) {
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line.contains(String.valueOf(OPEN_BRACKET))) {
        break;
      }
      if (line.contains(key)) {
        return line.split(EQUALITY_SIGN)[NOT_KEY];
      }
    }
    return null;
  }

  /**
   * Finds the section line
   * @param scanner - scanner of the file
   * @param section - section to find
   * @return boolean - answer is found
   */
  private boolean findSection(Scanner scanner, String section) {
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      if (line.equals(section)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Creates section from section name
   * @param section - section name
   * @return String - section
   */
  private String createSection(String section) {
    return new StringBuilder(section).append(CLOSE_BRACKET).reverse().append(OPEN_BRACKET)
        .reverse().toString();
  }
}
