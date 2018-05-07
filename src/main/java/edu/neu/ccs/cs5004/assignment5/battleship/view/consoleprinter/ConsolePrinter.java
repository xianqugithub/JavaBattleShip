package edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaWaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.game.DebugMode;
import edu.neu.ccs.cs5004.assignment5.battleship.model.game.GameMode;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;


public interface ConsolePrinter {

  /**
   * Creator of a new Console Printer.
   *
   * @return a new Console Printer.
   */
  static ConsolePrinter createConsolePrinter() {
    return new Printer();
  }

  /**
   * Print a game mode state
   *
   * @param game the game to be printed.
   */
  void toConsole(DebugMode game);

  /**
   * Print a debug game state
   *
   * @param game the game to be printed.
   */
  void toConsole(GameMode game);

  /**
   * Print the map.
   *
   * @param map the map to be printed.
   */
  void toConsole(Map map);

  /**
   * Print the open sea water cell.
   *
   * @param cell to be printed.
   */
  void toConsole(OpenSeaWaterCell cell);

  /**
   * Print the gap water cell.
   *
   * @param cell to be printed.
   */
  void toConsole(GapWaterCell cell);

  /**
   * Print the specific ship cell.
   *
   * @param cell to be printed.
   */
  void toConsole(SpecificShipCell cell);

  /**
   * Print the enemy ship cell.
   *
   * @param cell to be printed.
   */
  void toConsole(EnemyShipCell cell);
}
