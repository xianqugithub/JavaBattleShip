package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

public class EnemyShipCell extends AbstractShipCell {
  EnemyShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit, isSunk);
  }

  @Override
  public AttackResult attackResult() {
    return AttackResult.createHit();
  }

  @Override
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public Cell attackCell() {
    return new EnemyShipCell(true, false);
  }
}
