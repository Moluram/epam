package com.moluram.task.dev5.Finder.Criteria;

import com.moluram.task.dev5.Finder.Qualifications.Qualification;
import com.moluram.task.dev5.Finder.Solver.ModelSolver;
import com.moluram.task.dev5.Finder.Solver.SimplexMethodMaximizationSolver;
import com.moluram.task.dev5.Finder.Solver.SimplexMethodMinimizationSolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Serve for creating objects of Criterion
 */
public class CriteriaFactory {
  private static final int FIRST = 0;

  /**
   * Creates list of criterion objects
   * @param qualificationList - list of qualifications for the criterion
   * @return List<Criterion> - list of criterion objects
   */
  public List<Criterion> getListOfCriteria(List<Qualification> qualificationList) {
    List<Criterion> criterionList = new ArrayList<>();
    criterionList.add(new ProductionOutput(qualificationList,
        new SimplexMethodMaximizationSolver()));
    criterionList.add(new CostOfProductivity(qualificationList,
        new SimplexMethodMinimizationSolver()));
    criterionList.add(new NumberOfHigherEmployers(qualificationList,
        new SimplexMethodMinimizationSolver(),  qualificationList.get(FIRST)));
    return criterionList;
  }
}
