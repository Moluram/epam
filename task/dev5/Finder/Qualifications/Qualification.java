package com.moluram.task.dev5.Finder.Qualifications;

/**
 * Represent a qualification for the employees
 */
public abstract class Qualification {
  private final Integer salary;
  private final Integer productivity;

  /**
   * Represent a highness of this qualification
   */
  private final int priority;
  private final String qualificationName;

  public Qualification(Integer salary, Integer productivity, int priority, String qualificationName) {
    this.salary = salary;
    this.productivity = productivity;
    this.priority = priority;
    this.qualificationName = qualificationName;
  }

  public Integer getSalary() {
    return salary;
  }

  public Integer getProductivity() {
    return productivity;
  }

  public int getPriority() {
    return priority;
  }

  public String getQualificationName() {
    return qualificationName;
  }
}
