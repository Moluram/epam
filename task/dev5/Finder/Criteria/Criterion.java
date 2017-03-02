package com.moluram.task.dev5.Finder.Criteria;

import com.moluram.task.dev5.Finder.Qualifications.Qualification;

import java.util.Map;

/**
 * Represent a criteria for getting an amount of needed employees
 */
public interface Criterion {
  /**
   * Returns description of this criteria
   * @return String - description
   */
  String getDescription();

  /**
   * Returns map of qualifications and their number
   * @param cost String - max summary cost of qualifications
   * @param production String - max summary production of qualifications
   * @return Map<Qualification, Double> - map of qualifications an their number
   */
  Map<Qualification,Double> getAmountOfEmployees(String cost, String production);
}
