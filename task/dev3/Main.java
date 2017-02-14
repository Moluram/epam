package com.moluram.task.dev3;

import com.moluram.task.dev3.Program.DataBase.FakeDatabase;
import com.moluram.task.dev3.Program.DatabaseProgram;
import com.moluram.task.dev3.Program.InputOtput.ConsoleIO;
import com.moluram.task.dev3.Program.Mediators.DatabaseMediator;
import com.moluram.task.dev3.Program.Mediators.IOMediator;
import com.moluram.task.dev3.Program.Operations.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Moluram on 14.02.2017.
 */
public class Main {

  /**
   * Executes database program
   * @param args
   */
  public static void main(String[] args) {
    IOMediator ioMediator = new IOMediator(new ConsoleIO());
    DatabaseProgram databaseProgram = new DatabaseProgram(createListOfOperations(ioMediator),
        ioMediator);
    databaseProgram.start();
  }

  /**
   * Creates list of operations for database program
   * @param ioMediator - mediator for the operations to work with io (input-output)
   * @return List<IOperation> -  list of operations
   */
  private static List<IOperation> createListOfOperations(IOMediator ioMediator) {
    DatabaseMediator databaseMediator = new DatabaseMediator(new FakeDatabase());
    List<IOperation> operationList = new LinkedList<>();
    operationList.add(new NamesakesOperation(databaseMediator, ioMediator));
    operationList.add(new TheMostPopularFemaleNameOperation(databaseMediator, ioMediator));
    operationList.add(new TheOldestUserOperation(databaseMediator, ioMediator));
    operationList.add(new AddOperation(databaseMediator, ioMediator));
    return operationList;
  }
}
