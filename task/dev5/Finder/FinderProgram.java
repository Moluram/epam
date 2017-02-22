package com.moluram.task.dev5.Finder;

import com.moluram.task.dev5.Finder.Criteria.CriteriaFactory;
import com.moluram.task.dev5.Finder.Criteria.Criterion;
import com.moluram.task.dev5.Finder.InputOutput.IInputOutput;
import com.moluram.task.dev5.Finder.Qualifications.Qualification;

import java.util.List;
import java.util.Map;

/**
 * Program serve for finding needed amount of employees
 */
public class FinderProgram {
  private static final String HELLO_MESSAGE = "Please enter your values in a such way:\n" +
      " <money> <required productivity> <number of criteria>\n";
  private static final String DOT = ". ";
  private static final String SPACE = " ";
  private static final String INCORRECT_INPUT = "Incorrect input!";
  private static final String EMPTY = "";
  private static final String NEXT_LINE = "\n";

  private static final int THIRD_ELEMENT = 2;
  private static final int AMOUNT_OF_MONEY = 0;
  private static final int PRODUCTIVITY = 1;

  private final IInputOutput io;

  /**
   * List of existing qualifications
   */
  private final List<Qualification> qualificationList;

  /**
   * List of existing criteria
   */
  private final List<Criterion> listOfCriteria;

  public FinderProgram(IInputOutput consoleIO, List<Qualification> qualificationList) {
    this.io = consoleIO;
    this.qualificationList = qualificationList;
    this.listOfCriteria = new CriteriaFactory().getListOfCriteria(qualificationList);
  }

  /**
   * Executes the program
   */
  public void execute() {
    io.printLine(createHelloMessage());
    String[] line;
    while (true) {
      line = io.getNextLine().split(SPACE);
      try {
        Criterion criterion = listOfCriteria.get(Integer.parseInt(line[THIRD_ELEMENT]));
        Map<Qualification, Double> qualificationMap = criterion.getAmountOfEmployees
            (line[AMOUNT_OF_MONEY], line[PRODUCTIVITY]);
        outputMap(qualificationMap);
        break;
      } catch (ArrayIndexOutOfBoundsException e) {
        io.printLine(INCORRECT_INPUT);
      }
    }
  }

  /**
   * Outputs the mao through io object
   * @param qualificationMap - map to output
   */
  private void outputMap(Map<Qualification, Double> qualificationMap) {
    String outputMessage = EMPTY;
    for (Map.Entry<Qualification, Double> entry: qualificationMap.entrySet()){
      outputMessage += entry.getKey().getQualificationName() + SPACE + entry.getValue() + NEXT_LINE;
    }
    io.printLine(outputMessage);
  }

  /**
   * Creates a message for start of the executing
   * @return String - message
   */
  private String createHelloMessage() {
    String helloMessage = HELLO_MESSAGE;
    int counter = 0;
    for (Criterion criteria: listOfCriteria) {
      helloMessage += counter++ + DOT + criteria.getDescription();
    }
    return helloMessage;
  }
}
