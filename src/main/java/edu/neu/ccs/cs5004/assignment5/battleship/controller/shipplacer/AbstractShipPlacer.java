package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.ShipConfiguration;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

/**
 * Represents an abstract ship placer in the program.
 */
abstract class AbstractShipPlacer implements ShipPlacer {

  /**
   * place a single ship at a specific location.
   *
   * @param row           the row number [R1-R10].
   * @param col           the col number [A-J].
   * @param configuration the configuration of the ship [H or V].
   * @param ship          the specific ship to be placed [Destroyer, BattleShip, Submarine,
   *                      Cruiser].
   * @param fleetMap      the fleetMap where the ships are placed.
   */
  void placeSingleShip(Row row, Col col, ShipConfiguration configuration, Ship ship, Map fleetMap) {
    if (configuration == ShipConfiguration.H) {
      for (int i = 0; i < ship.getSize(); i++) {
        int colNum = col.ordinal() + i;

        Col curCol = Col.values()[colNum];

        fleetMap.replaceCell(row, curCol, Cell.createSpecificShipCell(ship));

        if (row.ordinal() > 0) {
          fleetMap.replaceCell(Row.values()[row.ordinal() - 1], curCol, Cell.createGapWaterCell());
        }
        if (row.ordinal() < Row.values().length - 1) {
          fleetMap.replaceCell(Row.values()[row.ordinal() + 1], curCol, Cell.createGapWaterCell());
        }

      }

      if (col.ordinal() > 0) {
        fleetMap.replaceCell(row, Col.values()[col.ordinal() - 1], Cell.createGapWaterCell());
        if (row.ordinal() > 0) {
          fleetMap.replaceCell(Row.values()[row.ordinal() - 1], Col.values()[col.ordinal() - 1],
                  Cell.createGapWaterCell());
        }
        if (row.ordinal() < Row.values().length - 1) {
          fleetMap.replaceCell(Row.values()[row.ordinal() + 1], Col.values()[col.ordinal() - 1],
                  Cell.createGapWaterCell());
        }

      }

      if (col.ordinal() + ship.getSize() - 1 < Col.values().length - 1) {
        fleetMap.replaceCell(row, Col.values()[col.ordinal() + ship.getSize()], Cell
                .createGapWaterCell());
        if (row.ordinal() > 0) {
          fleetMap.replaceCell(Row.values()[row.ordinal() - 1], Col.values()[col.ordinal() + ship
                          .getSize()],
                  Cell.createGapWaterCell());
        }
        if (row.ordinal() < Row.values().length - 1) {
          fleetMap.replaceCell(Row.values()[row.ordinal() + 1], Col.values()[col.ordinal() + ship
                          .getSize()],
                  Cell.createGapWaterCell());
        }

      }


    } else {
      for (int j = 0; j < ship.getSize(); j++) {
        int rowNum = row.ordinal() + j;

        Row curRow = Row.values()[rowNum];

        fleetMap.replaceCell(curRow, col, Cell.createSpecificShipCell(ship));

        if (col.ordinal() > 0) {
          fleetMap.replaceCell(curRow, Col.values()[col.ordinal() - 1], Cell.createGapWaterCell());
        }
        if (col.ordinal() < Col.values().length - 1) {
          fleetMap.replaceCell(curRow, Col.values()[col.ordinal() + 1], Cell.createGapWaterCell());
        }

      }

      if (row.ordinal() > 0) {
        fleetMap.replaceCell(Row.values()[row.ordinal() - 1], col, Cell.createGapWaterCell());

        if (col.ordinal() > 0) {
          fleetMap.replaceCell(Row.values()[row.ordinal() - 1], Col.values()[col.ordinal() - 1],
                  Cell.createGapWaterCell());
        }
        if (col.ordinal() < Col.values().length - 1) {
          fleetMap.replaceCell(Row.values()[row.ordinal() - 1], Col.values()[col.ordinal() + 1],
                  Cell.createGapWaterCell());
        }

      }

      if (row.ordinal() + ship.getSize() - 1 < Row.values().length - 1) {
        fleetMap.replaceCell(Row.values()[row.ordinal() + ship.getSize()], col, Cell
                .createGapWaterCell());

        if (col.ordinal() > 0) {
          fleetMap.replaceCell(Row.values()[row.ordinal() + ship.getSize()], Col.values()[col
                          .ordinal() - 1],
                  Cell.createGapWaterCell());
        }
        if (col.ordinal() < Col.values().length - 1) {
          fleetMap.replaceCell(Row.values()[row.ordinal() + ship.getSize()], Col.values()[col
                          .ordinal() + 1],
                  Cell.createGapWaterCell());
        }


      }
    }
  }

  /**
   * Getter of current location's availiblity to place a ship.
   *
   * @param row           the row number [R1-R10].
   * @param col           the col number [A-J].
   * @param configuration the configuration of the ship [H or V].
   * @param shipSize      the size of the ship [1,2,3,4].
   * @param fleetMap      the fleetMap where the ship to be placed.
   * @return if the current location is a valid position to place a ship with specific size and
   *             configuration.
   */
  boolean isValidLocation(Row row, Col col, ShipConfiguration configuration, int shipSize, Map
          fleetMap) {
    if (configuration == ShipConfiguration.H) {
      for (int i = 0; i < shipSize; i++) {
        int colNum = col.ordinal() + i;

        if (colNum >= Col.values().length || !fleetMap.getPos(row, Col.values()[colNum])
                .placeShipOnCell()) {
          return false;
        }
      }
      return true;
    } else {
      for (int j = 0; j < shipSize; j++) {
        int rowNum = row.ordinal() + j;
        if (rowNum >= Row.values().length || !fleetMap.getPos(Row.values()[rowNum], col)
                .placeShipOnCell()) {
          return false;
        }
      }
      return true;
    }

  }


}


