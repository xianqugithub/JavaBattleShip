package edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaWaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.game.DebugMode;
import edu.neu.ccs.cs5004.assignment5.battleship.model.game.GameMode;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;


public class Printer implements ConsolePrinter {

  /**
   * Print the game in the game mode.
   * @param game the game to be printed.
   */
  public void toConsole(GameMode game) {
    final ConsolePrinter printer = new Printer();
    System.out.println("***********************************************");
    System.out.println("****************  New Round  ******************");
    System.out.println("***********************************************");
    System.out.println("This is your fleet map");
    game.getPlayer1().getFleetMap().prettyPrint(printer);
    System.out.println("");
    System.out.println("This is your guess map");
    game.getPlayer1().getGuessMap().prettyPrint(printer);
    System.out.println("");
    System.out.println("******************************");
    System.out.println("       Your ships left: " + game.getPlayer1().getNumOfShips());
    System.out.println(" Opponent's ships left: " + game.getPlayer2().getNumOfShips());
    System.out.println("******************************");
    System.out.println();
  }

  /**
   * print the game in the debug mode.
   * @param game the game to be printed.
   */
  public void toConsole(DebugMode game) {
    final ConsolePrinter printer = new Printer();
    System.out.println("***********************************************");
    System.out.println("****************  New Round  ******************");
    System.out.println("***********************************************");
    System.out.println("This is your fleet map");
    game.getPlayer1().getFleetMap().prettyPrint(printer);
    System.out.println("");
    System.out.println("This is your guess map");
    game.getPlayer1().getGuessMap().prettyPrint(printer);
    System.out.println("");
    System.out.println("This is your opponent fleet map");
    game.getPlayer2().getFleetMap().prettyPrint(printer);
    System.out.println("");
    System.out.println("This is your opponent guess map");
    game.getPlayer2().getGuessMap().prettyPrint(printer);
    System.out.println("");
    System.out.println("******************************");
    System.out.println("       Your ships left: " + game.getPlayer1().getNumOfShips());
    System.out.println(" Opponent's ships left: " + game.getPlayer2().getNumOfShips());
    System.out.println("******************************");
    System.out.println();
  }

  /**
   * Print the open sea water cell.
   * @param cell to be printed.
   */
  public void toConsole(OpenSeaWaterCell cell) {
    if (cell.getIsHit()) {
      System.out.print("O");
    } else {
      System.out.print(" ");
    }
  }

  /**
   * Print the gap water cell.
   * @param cell to be printed.
   */
  public void toConsole(GapWaterCell cell) {
    if (cell.getIsHit()) {
      System.out.print("O");
    } else {
      System.out.print("-");
    }
  }

  /**
   * Print the specific ship cell.
   * @param cell to be printed.
   */
  public void toConsole(SpecificShipCell cell) {
    if (cell.getIsHit()) {
      System.out.print("X");
    } else {
      String shipType = cell.getShip().getShipType();
      switch (shipType) {
        case "BattleShip":
          System.out.print("B");
          break;
        case "Cruiser":
          System.out.print("C");
          break;
        case "Destroyer":
          System.out.print("D");
          break;
        default:
          System.out.print("S");
          break;
      }
    }

  }

  /**
   * Print the enemy ship cell.
   * @param cell to be printed.
   */
  public void toConsole(EnemyShipCell cell) {
    System.out.print("X");
  }

  /**
   * Print the map.
   * @param map the map to be printed.
   */
  public void toConsole(Map map) {

    ConsolePrinter printer = new Printer();

    System.out.print("  ");

    for (Col col : Col.values()) {
      System.out.print(" " + col);
    }

    System.out.println();

    for (Row row : Row.values()) {

      int curRow = row.ordinal() + 1;

      if (curRow < Row.values().length) {
        System.out.print(curRow + " ");
      } else {
        System.out.print(curRow);
      }

      for (Col col : Col.values()) {
        System.out.print(" ");
        map.getPos(row, col).prettyPrint(printer);
      }
      //

      if (curRow < Row.values().length) {
        System.out.print("  " + curRow);
      } else {
        System.out.print(" " + curRow);
      }

      System.out.println();
    }

    System.out.print("  ");

    for (Col col : Col.values()) {
      System.out.print(" " + col);
    }
    System.out.println();
  }


}


