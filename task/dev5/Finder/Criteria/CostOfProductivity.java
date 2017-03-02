package com.moluram.task.dev5.Finder.Criteria;

import com.moluram.task.dev5.Finder.Qualifications.Qualification;
import com.moluram.task.dev5.Finder.Solver.ModelSolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Criteria for getting number of employees based of their summary productivity
 */
class CostOfProductivity implements Criterion {
  private static final String MIN_COST_OF_PRODUCTIVITY_DESCRIPTION = "The minimum cost for a" +
      " fixed productivity.\n";

  private static final int TWO_ROWS = 2;
  private static final int FIRST_ROW = 0;
  private static final int SECOND_ROW = 1;

  /**
   * List of existing qualifications
   */
  private final List<Qualification> programmerList;

  /**
   * Solver of equations
   */
  private final ModelSolver modelSolver;

  /**
   * Equations matrix based on this equations:
   * f(c) = n1*c1 + n2*c2 + ... + nn * cn - cost restrictions (c - means cost)
   * f(p) >= n1*p1 + n2*p2 + ... + nn * pn - needed production (p - means production, n - number)
   */
  private Integer[][] equationsMatrix;

  CostOfProductivity(List<Qualification> programmerList, ModelSolver modelSolver) {
    this.programmerList = programmerList;
    this.modelSolver = modelSolver;
  }

  @Override
  public String getDescription() {
    return  MIN_COST_OF_PRODUCTIVITY_DESCRIPTION;
  }

  /**
   * Returns map of qualifications and their number
   * @param cost String - max summary cost of qualifications
   * @param production String - max summary production of qualifications
   * @return Map<Qualification, Double> - map of qualifications an their number
   */
  @Override
  public Map<Qualification, Double> getAmountOfEmployees(String cost, String production) {
    createEquationsMatrix(Integer.parseInt(cost), Integer.parseInt(production));
    Double[] results = modelSolver.calculate(equationsMatrix, new Double[programmerList.size()]);
    return parseResultsIntoMap(results);
  }

  /**
   * Parses results into qualifications map
   * @param results - results to parse
   * @return Map<Qualification, Double> - qualifications map
   */
  private Map<Qualification, Double> parseResultsIntoMap(Double[] results) {
    Map<Qualification, Double> qualificationMap = new HashMap<>();
    for (int i = 0; i < results.length; i++) {
      qualificationMap.put(programmerList.get(i), Math.floor(results[i]));
    }
    return qualificationMap;
  }

  /**
   * Creates matrix that represent this equations :
   * f(c) = n1*c1 + n2*c2 + ... + nn * cn - cost restrictions (c - means cost)
   * f(p) >= n1*p1 + n2*p2 + ... + nn * pn - needed production (p - means production, n - number)
   * @param cost int - f(c)
   * @param production int - f(p)
   */
  private void createEquationsMatrix(int cost, int production) {
    equationsMatrix = new Integer[TWO_ROWS][programmerList.size() + 1];
    int qualificationCounter = 0;
    equationsMatrix[FIRST_ROW][qualificationCounter] = production;
    equationsMatrix[equationsMatrix.length - 1][qualificationCounter++] = 0;
    for (Qualification qualification: programmerList) {
      equationsMatrix[SECOND_ROW][qualificationCounter] = -1 * qualification.getSalary();
      equationsMatrix[FIRST_ROW][qualificationCounter++] = qualification.getProductivity();
    }
  }
}
