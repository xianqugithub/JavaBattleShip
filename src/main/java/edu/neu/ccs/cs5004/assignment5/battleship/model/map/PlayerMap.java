package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;


class PlayerMap implements Map {

  private Cell[][] board;

  PlayerMap() {
    board = new Cell[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        board[i][j] = Cell.createOpenSeaWaterCell();
      }
    }
  }

  public Cell getPos(Row row, Col col) {
    int rowNum = row.ordinal();
    int colNum = col.ordinal();

    return board[rowNum][colNum];
  }


  public void replaceCell(Row row, Col col, Cell newCell) {
    int rowNum = row.ordinal();
    int colNum = col.ordinal();

    board[rowNum][colNum] = newCell;
  }

  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Map map1 = (Map) obj;

    for (Row row : Row.values()) {
      for (Col col : Col.values()) {
        if (!this.getPos(row, col).equals(map1.getPos(row, col))) {
          return false;
        }
      }
    }

    return true;

  }

  @Override
  public int hashCode() {
    int result = 0;

    for (Row row : Row.values()) {
      for (Col col : Col.values()) {
        result += this.getPos(row, col).hashCode();
      }
    }

    return result;
  }


}
