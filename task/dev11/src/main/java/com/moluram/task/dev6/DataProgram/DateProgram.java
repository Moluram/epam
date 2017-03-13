package com.moluram.task.dev6.DataProgram;

import com.moluram.task.dev6.DataProgram.Data.Date;
import com.moluram.task.dev6.DataProgram.Data.DateFactory;
import com.moluram.task.dev6.DataProgram.Data.Patterns.DatePattern;
import com.moluram.task.dev6.DataProgram.InputOutput.IInputOutput;

/**
 * Class represent a formatter for date and time
 */
public class DateProgram {
  /**
   * Escape-symbol
   */
  private static final char SLASH = '\\';

  private final IInputOutput io;

  /**
   * Using for formatting date and time
   */
  private final Date date;

  /**
   * Start index of substring to compare with patterns
   */
  private int startOfSubstring = 0;

  /**
   * End index of substring to compare with patterns
   */
  private int endOfSubstring = 0;

  /**
   * Creates a simple object
   * @param io - input output object
   */
  public DateProgram(IInputOutput io) {
    this.io = io;
    this.date = new DateFactory().getDateObject();
  }

  /**
   * Starts execution of the program
   *
   */
  public void execute() {
    String line = io.getNextLine();
    for (DatePattern pattern : date.getListOfPatterns()) {
      startOfSubstring = 0;
      endOfSubstring = pattern.getPattern().length();
      String result = pattern.getResult();
      while (endOfSubstring <= line.length()) {
        line = tryChangeLine(line, pattern, result);
      }
    }
    io.printLine(line.replace(String.valueOf(SLASH), ""));
  }

  /**
   * Tries to change line with pattern
   * @param line - line to change
   * @param pattern - pattern to use
   * @param result - result of change
   * @return String - result of change
   */
  private String tryChangeLine(String line, DatePattern pattern, String result) {
    if (startOfSubstring > 0) {
      if (line.charAt(startOfSubstring - 1) != SLASH) {
        line = changeLine(line, pattern, result);
      }
    } else {
      line = changeLine(line, pattern, result);
    }
    startOfSubstring++;
    endOfSubstring++;
    return line;
  }

  /**
   * Replace substring with result of the pattern if the pattern is fits
   * @param line - line to change
   * @param pattern - pattern to use
   * @param result - result of change
   * @return String - result of change
   */
  private String changeLine(String line, DatePattern pattern, String result) {
    if (line.substring(startOfSubstring, endOfSubstring).equals(pattern.getPattern())) {
      line = line.substring(0, startOfSubstring) + result + line.substring(endOfSubstring);
      startOfSubstring += pattern.getPattern().length() - result.length();
      endOfSubstring += pattern.getPattern().length() - result.length();
    }
    return line;
  }
}
