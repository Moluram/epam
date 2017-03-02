package com.moluram.task.dev8;

import com.moluram.task.dev8.InputOutput.ConsoleIO;
import com.moluram.task.dev8.InputOutput.IInputOutput;
import com.moluram.task.dev8.Matrix.MatrixFormatException;
import com.moluram.task.dev8.Matrix.MatrixIO;
import com.moluram.task.dev8.Matrix.MatrixCalculator;

/**
 * Class serve for starting the execution of the program
 */
public class Main {
  private static final String MATRIX_FORMAT_MESSAGE = "Matrix can not be multiplied!";

  /**
   * Starts execution of the program
   * @param args - arguments from command line
   */
  public static void main(String[] args) {
    IInputOutput consoleIO = new ConsoleIO();
    MatrixIO matrixIO = new MatrixIO(consoleIO);
    double[][] matrix;
    try {
      matrix = new MatrixCalculator().multiply(
          matrixIO.getMatrixFromInput(), matrixIO.getMatrixFromInput());
      matrixIO.printMatrix(matrix);
    } catch (MatrixFormatException e) {
      consoleIO.printLine(MATRIX_FORMAT_MESSAGE);
    }
  }
}
