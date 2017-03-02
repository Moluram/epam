package com.moluram.task.dev8.Matrix;

import com.moluram.task.dev8.InputOutput.IInputOutput;

/**
 * Class serve for input-output matrix
 */
public class MatrixIO {
  private static final String ENTER_MESSAGE = "Please, enter number of columns and number of rows" +
      " :\n";
  private static final java.lang.String SPACE = " ";
  private static final String NOT_ENOUGH_ELEMENTS_MESSAGE = "Not enough elements!";
  private static final String WRONG_INPUT = "Incorrect input!";
  private static final String MATRIX_ENTER_MESSAGE_FIRST_PART = "Please, enter ";
  private static final String MATRIX_ENTER_MESSAGE_SECOND_PART = " rows with ";
  private static final String MATRIX_ENTER_MESSAGE_THIRD_PART = " columns elements in it : \n";
  private static final String TO_NEXT_LINE = "\n";
  private static final String EMPTY = "";
  private static final String WHITESPACE = " ";

  private final IInputOutput io;
  private int numOfColumns;
  private int numOfRows;

  public MatrixIO(IInputOutput io) {
    this.io = io;
  }

  /**
   * Gets matrix from input
   * @return double[][] - matrix
   */
  public double[][] getMatrixFromInput() {
    getXY();
    return getMatrix(numOfColumns, numOfRows);
  }

  /**
   * Prints matrix
   * @param matrix - matrix to print
   */
  public void printMatrix(double[][] matrix) {
    for (double[] row: matrix) {
      String line = EMPTY;
      for (double column: row) {
        line += String.valueOf(column) + WHITESPACE;
      }
      io.printLine(line + TO_NEXT_LINE);
    }
  }

  /**
   * Gets number of columns and number of rows for the matrix from input
   */
  private void getXY() {
    while (true) {
      io.printLine(ENTER_MESSAGE);
      String[] line = io.getNextLine().split(SPACE);
      try {
        numOfRows = Integer.parseInt(line[0]);
        numOfColumns = Integer.parseInt(line[1]);
        if (numOfColumns < 0 || numOfColumns < 0) {
          throw new NumberFormatException();
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        io.printLine(NOT_ENOUGH_ELEMENTS_MESSAGE);
        continue;
      } catch (NumberFormatException e) {
        io.printLine(WRONG_INPUT);
        continue;
      }
      break;
    }
  }

  /**
   * Gets matrix with given number of columns and number of rows from the input
   * @param numOfColumns - number of columns in the result matrix
   * @param numOfRows - number of rows in the result matrix
   * @return double[][] - matrix
   */
  private double[][] getMatrix(int numOfColumns, int numOfRows) {
    io.printLine(MATRIX_ENTER_MESSAGE_FIRST_PART + this.numOfRows
        + MATRIX_ENTER_MESSAGE_SECOND_PART + this.numOfColumns + MATRIX_ENTER_MESSAGE_THIRD_PART);
    double[][] matrix = new double[this.numOfRows][this.numOfColumns];
    for (int indexRow = 0; indexRow < this.numOfRows;) {
      String[] line = io.getNextLine().split(SPACE);
      try {
        for (int indexColumn = 0; indexColumn < this.numOfColumns; indexColumn++) {
          matrix[indexRow][indexColumn] = Double.parseDouble(line[indexColumn]);
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        io.printLine(NOT_ENOUGH_ELEMENTS_MESSAGE);
        continue;
      } catch (NumberFormatException e) {
        io.printLine(WRONG_INPUT);
        continue;
      }
      indexRow++;
    }
    return matrix;
  }
}
