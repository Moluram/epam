package com.moluram.task.dev3.Program.DataObjects;

import com.moluram.task.dev3.Program.GlobalConstants;

/**
 * Represents a single user with name, surname, sex and age
 */
public class User {
  private static final String NAME_EXCEPTION_MESSAGE = "Not correct full name!";
  private static final String SEX_EXCEPTION_MESSAGE = "Not correct sex!";
  private static final String REGEX_VALUE_FOR_DECIMALS = "[a-zA-Z]*^[0-9]+$";
  private static final String SPACE = " ";

  private String name;
  private String surname;
  private String sex;
  private int age;

  /**
   * Constructor which validate given values
   * @param name - name of the user
   * @param surname - surname of the user
   * @param sex - sex of the user
   * @param age - age of the user
   * @throws NumberFormatException - throws whether the something wrong with input
   */
  public User(String name, String surname, String sex, int age) throws NumberFormatException {
    String regexString = name + surname;
    if (regexString.matches(REGEX_VALUE_FOR_DECIMALS)) {
      throw new NumberFormatException(NAME_EXCEPTION_MESSAGE);
    }
    if (!sex.equals(GlobalConstants.MALE) && !sex.equals(GlobalConstants.FEMALE)) {
      throw new NumberFormatException(SEX_EXCEPTION_MESSAGE);
    }
    this.sex = sex;
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  /**
   * Converts user to string
   * @return String - string view of user
   */
  @Override
  public String toString() {
    return name + SPACE + surname + SPACE + sex + SPACE + age;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getSex() {
    return sex;
  }

  public int getAge() {
    return age;
  }
}
