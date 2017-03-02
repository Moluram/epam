package com.moluram.task.dev5;


import com.moluram.task.dev5.Finder.FinderProgram;
import com.moluram.task.dev5.Finder.InputOutput.ConsoleIO;
import com.moluram.task.dev5.Finder.Qualifications.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Serve for executing the program
 */
public class Main {
  private static final Integer JUNIOR_SALARY = 700;
  private static final Integer JUNIOR_PRODUCTIVITY = 30;
  private static final int JUNIOR_PRIORITY = 1;
  private static final String JUNIOR_NAME = "Junior";

  private static final Integer MIDDLE_SALARY = 1200;
  private static final Integer MIDDLE_PRODUCTIVITY = 50;
  private static final int MIDDLE_PRIORITY = 2;
  private static final String MIDDLE_NAME = "Middle";

  private static final Integer SENIOR_SALARY = 2400;
  private static final Integer SENIOR_PRODUCTIVITY = 70;
  private static final int SENIOR_PRIORITY = 3;
  private static final String SENIOR_NAME = "Senior";

  private static final Integer LEAD_PRODUCTIVITY = 90;
  private static final Integer LEAD_SALARY = 4800;
  private static final int LEAD_PRIORITY = 4;
  private static final String LEAD_NAME = "Lead";

  /**
   * Executes the program
   * @param args - arguments from a command line
   */
  public static void main(String[] args) {
    List<Qualification> qualificationList = new ArrayList<>();
    qualificationList.add(new Junior(JUNIOR_SALARY, JUNIOR_PRODUCTIVITY, JUNIOR_PRIORITY,
        JUNIOR_NAME));
    qualificationList.add(new Middle(MIDDLE_SALARY, MIDDLE_PRODUCTIVITY, MIDDLE_PRIORITY,
        MIDDLE_NAME));
    qualificationList.add(new Senior(SENIOR_SALARY, SENIOR_PRODUCTIVITY, SENIOR_PRIORITY,
        SENIOR_NAME));
    qualificationList.add(new Lead(LEAD_SALARY, LEAD_PRODUCTIVITY, LEAD_PRIORITY,
        LEAD_NAME));
    FinderProgram finderProgram = new FinderProgram(new ConsoleIO(), qualificationList);
    finderProgram.execute();
  }
}
