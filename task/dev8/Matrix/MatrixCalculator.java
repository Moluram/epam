package com.moluram.task.dev8.Matrix;

/**
 * Class serve for working with matrix. In this case for multiplying them
 */
public class MatrixCalculator {
  /**
   * Multiplying two given matrix
   * @param A - given matrix
   * @param B - given matrix
   * @throws MatrixFormatException - throws whether the given matrix can't be multiply
   * @return double[][] - result matrix
   */
  public double[][] multiply(double[][] A, double[][] B) throws MatrixFormatException {
    B = transpose(B);
    if (A.length != B.length) {
      throw new MatrixFormatException();
    }
    double[][] C = new double[A.length][B.length];
    for (int i = 0; i < A.length; i++) {
      for (int y = 0; y < B.length; y++) {
        C[i][y] = getResultElement(A[i], B[i]);
      }
    }
    return C;
  }

  /**
   * Gets result of calculations on row and column of matrix to get one element
   * @param A - row from first matrix
   * @param B - columnt from second
   * @return double - result
   */
  private double getResultElement(double[] A, double[] B) {
    double sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i] * B[i];
    }
    return sum;
  }

  /**
   * Transposes given matrix
   * @param matrix - matrix to transpose
   * @return double[][] - matrix
   */
  private static double[][] transpose(double[][] matrix) {
    int rowLength = matrix[0].length;
    double [][] tMatrix = new double[rowLength][];
    for (int i = 0; i < rowLength; i++) {
      tMatrix[i] = new double[matrix.length];
    }
    for (int i = 0; i < matrix.length; i++) {
      double[] tArr = matrix[i];
      for (int j = 0; j < rowLength; j++) {
        tMatrix[j][i] = tArr[j];
      }
    }
    return tMatrix;
  }
}
