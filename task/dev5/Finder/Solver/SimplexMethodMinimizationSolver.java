package com.moluram.task.dev5.Finder.Solver;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent an implementation of simplex method for minimization
 */
public class SimplexMethodMinimizationSolver implements ModelSolver {
  /**
   * Simplex table without basic variables
   */
  private double[][] table;

  private int rowsCount, columnsCount;

  /**
   * List of basis variables
   */
  private List<Integer> basis; //список базисных переменных

  /**
   * Calculates the solution for the given equations matrix
   * @param source - matrix of equations
   * @param result - array which represent number of answers
   * @return
   */
  public Double[] calculate(Integer[][] source, Double[] result) {
    tuneMethod(source);
    int mainCol, mainRow;
    while (!isItEnd()) {
      mainCol = findMainCol();
      mainRow = findMainRow(mainCol);
      basis.add(mainRow, mainCol);

      double[][] newTable = new double[rowsCount][columnsCount];

      newTable = recalculateRows(newTable, mainCol, mainRow);
      newTable = recalculateColumns(newTable, mainCol, mainRow);
      table = newTable;
    }
    return createResult(result);
  }

  /**
   * Gets basic needed variables
   * @param source - source to get variables
   */
  private void tuneMethod(Integer[][] source) {
    rowsCount = source.length;
    columnsCount = source[1].length;
    basis = new ArrayList<>();
    createTable(source);
    columnsCount = table[1].length;
  }

  /**
   * Creates simplex table from given equations matrix
   * @param source - equations matrix
   */
  private void createTable(Integer[][] source) {
    table = new double[rowsCount][columnsCount + rowsCount - 1];
    for (int i = 0; i < rowsCount; i++) {
      for (int j = 0; j < table[1].length; j++) {
        if (j < columnsCount)
          table[i][j] = source[i][j];
        else
          table[i][j] = 0;
      }
      exhibitOne(i);
    }
  }

  /**
   * Exhibits a ratio of 1 to the basic variable in row
   *
   * @param i - iterator
   */
  private void exhibitOne(int i) {
    if ((columnsCount + i) < table[1].length) {
      table[i][columnsCount + i] = 1;
      basis.add(columnsCount + i);
    }
  }

  /**
   * Recalculates columns of given table for a variable with given coordinates
   * @param newTable - table to recalculate
   * @param mainCol - variable coordinates
   * @param mainRow - variable coordinates
   * @return double[][] - result
   */
  private double[][] recalculateColumns(double[][] newTable, int mainCol, int mainRow) {
    for (int i = 0; i < rowsCount; i++) {
      if (i == mainRow) {
        continue;
      }
      for (int j = 0; j < columnsCount; j++) {
        newTable[i][j] = table[i][j] - table[i][mainCol] * newTable[mainRow][j];
      }
    }
    return newTable;
  }

  /**
   * Recalculates rows of given table for a variable with given coordinates
   * @param newTable - table to recalculate
   * @param mainCol - variable coordinates
   * @param mainRow - variable coordinates
   * @return double[][] - result
   */
  private double[][] recalculateRows(double[][] newTable, int mainCol, int mainRow) {
    for (int j = 0; j < columnsCount; j++) {
      newTable[mainRow][j] = table[mainRow][j] / table[mainRow][mainCol];
    }
    return newTable;
  }

  /**
   * Creates a result from a solve table
   * @param result - array in which variable will be placed
   * @return Double[] - result
   */
  private Double[] createResult(Double[] result) {
    //заносим в result найденные значения X
    for (int i = 0; i < result.length; i++) {
      int k = basis.indexOf(i + 1);
      if (k != -1) {
        result[i] = table[0][k];
      } else {
        result[i] = 0d;
      }
    }
    return result;
  }

  /**
   * Checks whether there is end of calculating
   * @return boolean - answer
   */
  private boolean isItEnd() {
    boolean flag = true;
    for (int j = 1; j < columnsCount; j++) {
      if (table[rowsCount - 1][j] < 0) {
        flag = false;
        break;
      }
    }
    return flag;
  }

  /**
   * Finds main column in the equation
   * @return int - number of column
   */
  private int findMainCol() {
    int mainCol = 1;
    for (int j = 2; j < columnsCount; j++) {
      if (table[rowsCount - 2][j] > table[rowsCount - 2][mainCol]) {
        mainCol = j;
      }
    }
    return mainCol;
  }

  /**
   * Finds main row in the equation
   * @return int - number of row
   */
  private int findMainRow(int mainCol) {
    int mainRow = 0;
    for (int i = 0; i < rowsCount - 1; i++)
      if (table[i][mainCol] > 0) {
        mainRow = i;
        break;
      }
    for (int i = mainRow; i < rowsCount - 1; i++) {
      if ((table[i][mainCol] > 0) && ((table[i][0] / table[i][mainCol]) > (table[mainRow][0] /
          table[mainRow][mainCol]))) {
        mainRow = i;
      }
    }
    return mainRow;
  }
}
