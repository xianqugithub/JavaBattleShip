package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;


public class DebugModeTest {

  private DebugMode debugMode;
  private ConsolePrinter consolePrinter;

  @Before
  public void setUp() throws Exception {

    consolePrinter = new Printer();

    ByteArrayInputStream in = new ByteArrayInputStream(("1\n"+"2\n"+"3\n"+"4\n").getBytes());
    System.setIn(in);
    debugMode = new DebugMode();
    System.setIn(System.in);

  }

  @Test
  public void prettyPrint() {
    debugMode.prettyPrint(consolePrinter);

  }
}