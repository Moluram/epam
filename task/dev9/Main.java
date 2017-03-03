package com.moluram.task.dev9;

import com.moluram.task.dev9.InputOutput.ConsoleIO;

import java.io.FileNotFoundException;

/**
 * Class serves for executing the program
 */
public class Main {
  private static final String SECTION_MESSAGE = "Please, enter the name of section : ";
  private static final String KEY_MESSAGE = "Please, enter the key : ";
  private static final String NOT_ENOUGH_COMMAND_LINE_ARGUMENTS = "Not enough command line" +
      " arguments!";
  private static final String KEY_VALUE_MESSAGE = "Value of the key : ";
  private static final String KEY_NOT_FOUND = "Key not found!";
  private static final String FILE_NOT_FOUND = "File not found!";

  /**
   * Executes the performance of the program
   * @param args - arguments from a command line
   */
  public static void main(String[] args) {
    ConsoleIO io = new ConsoleIO();
    try {
      String value = new ParameterReader().getValueOfParameter(args[0],
          io.getNextLine(SECTION_MESSAGE),  io.getNextLine(KEY_MESSAGE));
      if (value != null) {
        io.printLine(KEY_VALUE_MESSAGE + value);
      } else {
        io.printLine(KEY_NOT_FOUND);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      io.printLine(NOT_ENOUGH_COMMAND_LINE_ARGUMENTS);
    } catch (FileNotFoundException e) {
      io.printLine(FILE_NOT_FOUND);
    }
  }
}
