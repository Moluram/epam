package com.moluram.task.dev2.Tools.ExpressionTools;

import com.moluram.task.dev1.Helpers.Executor;
import com.moluram.task.dev2.Tools.Operators.Operator;

import java.util.List;

/**
 * Serve for creating Parser objects
 */
public class ExpressionWorker {
  public Parser getParser(String expression, List<Operator> operators) {
    return new ExpressionParser(expression, operators);
  }
}
