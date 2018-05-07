package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

/**
 * Represents a generic cell.
 */
public interface Cell {
  /**
   * get if a ship can be placed on the current cell.
   *
   * @return if a ship can be placed on current cell.
   */
  Boolean placeShipOnCell();

  /**
   * get an updated cell after attack.
   *
   * @return the updated cell after attack.
   */
  Cell attackCell();

  Cell updateTheShip();
  /**
   * get the attack result on the current cell.
   *
   * @return the attack result.
   */
  AttackResult attackResult();

  /**
   * get if the current cell has ship.
   *
   * @return if the current cell has a ship.
   */
  Boolean hasShip();


  /**
   * get if the current cell was hit.
   *
   * @return if the current cell was hit.
   */
  Boolean getIsHit();

  void prettyPrint(ConsolePrinter printer);

  static Cell createEnemyShipCell() {
    return new EnemyShipCell(true, false);
  }

  static Cell createGapWaterCell() {
    return new GapWaterCell(false);
  }

  static Cell createOpenSeaWaterCell() {
    return new OpenSeaWaterCell(false);
  }

  static Cell createSpecificShipCell(Ship ship) {
    return new SpecificShipCell(false, false, ship);
  }



}
