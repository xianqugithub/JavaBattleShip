package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

public interface Map {

  /**
   * Creator of the map.
   *
   * @return a new map.
   */
  static Map createMap() {
    return new PlayerMap();
  }

  /**
   * Getter of the cell at specific coordinate.
   *
   * @param row the row number [1-10].
   * @param col the col number [A-J].
   * @return the cell at designated position.
   */
  Cell getPos(Row row, Col col);

  /**
   * Place cell at specific coordinate with a new cell.
   *
   * @param row     the row number [1-10].
   * @param col     the col number [A-J].
   * @param newCell the new cell that used for placement.
   */
  void replaceCell(Row row, Col col, Cell newCell);

  /**
   * Print the map.
   *
   * @param printer the printer used to print the map.
   */
  void prettyPrint(ConsolePrinter printer);
}
