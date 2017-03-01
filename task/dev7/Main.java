package com.moluram.task.dev7;

import com.moluram.task.dev3.Program.InputOtput.ConsoleIO;
import com.moluram.task.dev7.DataProgram.Date.DateFormat;
import com.moluram.task.dev7.DataProgram.Date.DateFormatFactory;
import com.moluram.task.dev7.DataProgram.DateFormatValidatorProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * Serve for executing the program
 */
public class Main {
  /**
   * Executes the program
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    List<DateFormat> dateFormats = new ArrayList<>();
    dateFormats.add(new DateFormatFactory().getDateFormatObject());
    DateFormatValidatorProgram dateFormatValidatorProgram =
        new DateFormatValidatorProgram(new ConsoleIO(), dateFormats);
    dateFormatValidatorProgram.execute();
  }
}
