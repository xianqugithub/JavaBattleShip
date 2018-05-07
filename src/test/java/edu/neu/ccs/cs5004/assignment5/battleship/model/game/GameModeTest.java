package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class GameModeTest {
  private GameMode gameMode;
  private ConsolePrinter consolePrinter;

  @Before
  public void setUp() throws Exception {
    gameMode = new GameMode();
    consolePrinter = new Printer();
  }

  @Test
  public void prettyPrint() {
    gameMode.prettyPrint(consolePrinter);
  }
}