package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

public class OpenSeaWaterCell extends AbstractWaterCell {

  OpenSeaWaterCell(Boolean isHit) {
    super(isHit);
  }

  @Override
  public Boolean placeShipOnCell() {
    return true;
  }

  @Override
  public Cell attackCell() {
    return new OpenSeaWaterCell(true);
  }

  @Override
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

    if (super.equals(obj)) {
      return false;
    }

    OpenSeaWaterCell openSeaWaterCell = (OpenSeaWaterCell) obj;

    return placeShipOnCell().equals(openSeaWaterCell.placeShipOnCell());

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (placeShipOnCell() != null ? placeShipOnCell().hashCode() : 0);
    return result;
  }


}
