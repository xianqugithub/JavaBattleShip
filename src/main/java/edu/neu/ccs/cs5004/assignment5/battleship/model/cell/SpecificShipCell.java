package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

public class SpecificShipCell extends AbstractShipCell {

  private Ship ship;

  SpecificShipCell(Boolean isHit, Boolean isSunk, Ship ship) {
    super(isHit, isSunk);
    this.ship = ship;
  }

  @Override
  public Cell attackCell() {
    Ship attackedShip = this.ship.hitShip();
    if (attackedShip.isSunk()) {
      return new SpecificShipCell(true, true, attackedShip);
    } else {
      return new SpecificShipCell(true, false, attackedShip);
    }
  }

  /**
   * update the ship information of the current cell.
   *
   * @return a new cell with updated ship information.
   */
  public Cell updateTheShip() {
    Ship attackedShip = this.ship.hitShip();
    if (attackedShip.isSunk()) {
      return new SpecificShipCell(this.getIsHit(), true, attackedShip);
    } else {
      return new SpecificShipCell(this.getIsHit(), false, attackedShip);
    }
  }


  @Override
  public AttackResult attackResult() {
    Ship attackedShip = this.ship.hitShip();
    if (attackedShip.isSunk()) {
      return AttackResult.createSunk();
    } else {
      return AttackResult.createHit();
    }
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }


  public Ship getShip() {
    return this.ship;
  }


}
