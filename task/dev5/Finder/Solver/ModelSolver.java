package com.moluram.task.dev5.Finder.Solver;

import java.util.List;

/**
 * Represent an interface for equations solver classes
 */
public interface ModelSolver {
  /**
   * Returns an array of answers for the given matrix of equations
   * @param source - matrix of equations
   * @param result - array which represent number of answers
   * @return Double[] - array of answers
   */
  Double[] calculate(Integer[][] source, Double[] result);
}
