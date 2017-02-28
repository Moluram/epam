package com.moluram.task.dev4.StatisticsProgram;

import com.moluram.task.dev4.StatisticsProgram.DataBase.IDatabase;
import com.moluram.task.dev4.StatisticsProgram.DataObjects.PackOfLetters;
import com.moluram.task.dev4.StatisticsProgram.InputOutput.IInputOutput;
import com.moluram.task.dev4.StatisticsProgram.Operations.*;

import java.util.List;

/**
 * Class represent a statistic program for a text
 */
public class TextStatistic {
  private static final String WARNING_MESSAGE = "Do you want to continue enter?(y/n)";
  private static final String STRING_NO = "n";
  private static final String STRING_YES = "y";
  private static final String EMPTY_STRING = "";
  private static final String NUMBER_OF_WORDS_FIRST_PART = "Number of words with more than ";
  private static final String NUMBER_OF_WORDS_SECOND_PART = " letters : ";
  private static final String REGEX_VALUE_FOR_REPLACE = "[^a-zA-Z]";
  private static final String AWAITING_FOR_INPUT = "Awaiting for input:";

  private final INumberOfWordsOperation numberOfWordsOperation;
  private final ITheOccurrenceOfPacksOfLettersOperation theOccurrenceOfPacksInLettersOperation;
  private final IFrequencyCounterOperation frequencyCounter;
  private final IDatabase database;
  private final IInputOutput io;

  /**
   * Default count of iterations while warning message does not comes out
   */
  private final int defaultCountOfIterations;

  /**
   * Number of letters for a pack
   */
  private final int numberOfNeededLetters;

  /**
   * Number of found suitable words
   */
  private int numberOfNeededWords = 0;

  /**
   * Number of all existing packs
   */
  private long numberOfPacks = 0;

  /**
   * Constructor which gets an objects to work with and asks for objects OperationFactory to give
   * him objects
   * @param io - object to work with input-output
   * @param database - database to work with
   * @param count - count of iterations
   * @param numberOfNeededLetters - number of letters for a suitable words
   * @param numberOfLettersForAPack - number of letters for a pack
   */
  public TextStatistic(IInputOutput io, IDatabase database, int count, int numberOfNeededLetters,
                       int numberOfLettersForAPack) {
    this.io = io;
    this.database = database;
    this.defaultCountOfIterations = count;
    this.numberOfNeededLetters = numberOfNeededLetters;
    OperationFactory operationFactory = new OperationFactory();
    this.numberOfWordsOperation = operationFactory
        .getNumberOfWordsOperation(numberOfNeededLetters);
    this.theOccurrenceOfPacksInLettersOperation = operationFactory
        .getTheOccurrenceOfPacksOfLettersOperation(numberOfLettersForAPack);
    this.frequencyCounter = operationFactory.getFrequencyCounterOperation();
  }

  /**
   * Starts execution of the program
   */
  public void execute() {
    int counter = 0;
    String text;
    io.printLine(AWAITING_FOR_INPUT);
    while (true) {
      if (checkLineOnCounter(counter++)) {
        break;
      }
      text = io.getNextLine().replaceAll(REGEX_VALUE_FOR_REPLACE, EMPTY_STRING);
      numberOfNeededWords += numberOfWordsOperation.getCountOfSuitableWords(text);
      theOccurrenceOfPacksInLettersOperation.checkText(text);
      List<PackOfLetters> packOfLetters = theOccurrenceOfPacksInLettersOperation
          .getListOfPacksOfLetters();
      numberOfPacks += theOccurrenceOfPacksInLettersOperation.numberOfPacks();
      database.setPackOfLettersList(frequencyCounter.countOnPacks(splitLists(database
          .getPackOfLettersList(), packOfLetters), numberOfPacks));
    }
    outputTheResults();
  }

  /**
   * Checks whether counter is exceed the limit
   * @param i - counter to check
   * @return boolean - answer
   */
  private boolean checkLineOnCounter(int i) {
    if (i >= defaultCountOfIterations) {
      String nextLine = EMPTY_STRING;
      while (!nextLine.toLowerCase().equals(STRING_YES)) {
        io.printLine(WARNING_MESSAGE);
        nextLine = io.getNextLine();
        if (nextLine.toLowerCase().equals(STRING_NO)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Outputs the result of calculations
   */
  private void outputTheResults() {
    io.printLine(NUMBER_OF_WORDS_FIRST_PART + numberOfNeededLetters +
        NUMBER_OF_WORDS_SECOND_PART + numberOfNeededWords);
    for (PackOfLetters pair: database.getPackOfLettersList()) {
      io.printLine(pair.toString());
    }
  }

  /**
   * Splits two lists into one
   * @param packOfLettersList - list which will continue to live
   * @param packOfLetters - list which will be implement into packOfLettersList
   * @return List<PackOfLetters> - final list
   */
  private List<PackOfLetters> splitLists(List<PackOfLetters> packOfLettersList,
                                         List<PackOfLetters> packOfLetters) {
    mainLoop:
    for (PackOfLetters pairInInheritedList: packOfLetters) {
      for (PackOfLetters packOfLettersInMainList : packOfLettersList) {
        if (pairInInheritedList.equals(packOfLettersInMainList)) {
          packOfLettersInMainList.setNumberOfOccurrence(packOfLettersInMainList
              .getNumberOfOccurrence() + pairInInheritedList.getNumberOfOccurrence());
          continue mainLoop;
        }
      }
      packOfLettersList.add(pairInInheritedList);
    }
    return packOfLettersList;
  }
}
