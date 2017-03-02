package com.moluram.task.dev7.DataProgram;

import com.moluram.task.dev3.Program.InputOtput.IInputOutput;
import com.moluram.task.dev7.DataProgram.Date.DateFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represent a formatter for date and time
 */
public class DateFormatValidatorProgram {
  private static final String VALID = "Valid.";
  private static final String INVALID = "Invalid.";
  private static final String GET_NUMBER_OF_FORMAT_MESSAGE = "Please enter number of format to " +
      "check :\n";
  private static final String NON_DIGITS = "[^0-9]";
  private static final String REENTER_MESSAGE = "Format don't exist. Reenter please:\n";
  private static final String TO_NEXT_LINE = "\n";
  private static final String DOT = ". ";
  private static final String ENTER_LINE_MESSAGE = "Please enter line to check: \n";
  private static final int FIRST = 0;
  private static final String WHITESPACE = " ";
  private static final String EMPTY_STRING = "";

  private final IInputOutput io;

  /**
   * List of existing date formats
   */
  private final List<DateFormat> dateFormats;

  /**
   * List of existing separators
   */
  private final List<Character> listOfSeparators = new ArrayList<>();

  /**
   * Creates a simple object
   * @param io - input output object
   */
  public DateFormatValidatorProgram(IInputOutput io, List<DateFormat> dateFormats) {
    this.io = io;
    this.dateFormats = dateFormats;
  }

  /**
   * Starts execution of the program
   *
   */
  public void execute() {
    createListOfSeparators();
    int numberOfFormat = getNumberOfFormat() - 1;
    io.printLine(ENTER_LINE_MESSAGE);
    if (isValidDateFormat(io.getNextLine(), numberOfFormat)) {
      io.printLine(VALID);
    } else {
      io.printLine(INVALID);
    }
  }

  /**
   * Creates list of support separators
   */
  private void createListOfSeparators() {
    listOfSeparators.add(':');
    listOfSeparators.add('/');
    listOfSeparators.add('.');
  }

  /**
   * Checks whether the given line is supported by chosen date format
   * @param dateFormatLine - date format to check
   * @param numberOfFormat - number of format to check on
   * @return boolean - answer
   */
  private boolean isValidDateFormat(String dateFormatLine, int numberOfFormat) {
    return dateFormats.get(numberOfFormat)
        .isValidLine(new Splitter().splitLineBySeparators(dateFormatLine, listOfSeparators));
  }

  /**
   * Gets from the user number of format to use
   * @return int - nuber of format to use
   */
  private int getNumberOfFormat() {
    io.printLine(GET_NUMBER_OF_FORMAT_MESSAGE + createFormatDescrMessage());
    while (true) {
      String line = io.getNextLine();
      if (line.startsWith(WHITESPACE)) {
        line = line.replaceFirst(WHITESPACE, EMPTY_STRING);
      }
      if (checkLineForNumberOfFormat(line)) {
        return Integer.parseInt(line);
      }
      io.printLine(REENTER_MESSAGE);
    }
  }

  /**
   * Checks whether th given number of format is correct
   * @param line - line to check
   * @return boolean - answer
   */
  private boolean checkLineForNumberOfFormat(String line) {
    if (!line.matches(NON_DIGITS)) {
      int number = Integer.parseInt(line);
      if (number <= dateFormats.size() && number > 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * Creates summary description message of all date formats
   * @return String - message
   */
  private String createFormatDescrMessage() {
    StringBuilder message = new StringBuilder();
    for (int i = 0; i < dateFormats.size(); i++) {
      message.append(i + 1).append(DOT)
          .append(dateFormats.get(i).getDescriptionWithSeparator(listOfSeparators.get(FIRST)))
          .append(TO_NEXT_LINE);
    }
    return message.toString();
  }
}
