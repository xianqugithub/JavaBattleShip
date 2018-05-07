package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

abstract class AbstractShipCell extends AbstractCell {

  private Boolean isSunk;

  AbstractShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit);
    this.isSunk = isSunk;
  }

  public Boolean getIsSunk() {
    return this.isSunk;
  }

  public Boolean placeShipOnCell() {
    return false;
  }

  @Override
  public Boolean hasShip() {
    return true;
  }
}
