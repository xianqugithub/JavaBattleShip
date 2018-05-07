package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents a Cruiser.
 */
class Cruiser extends AbstractShip {
  Cruiser(Integer numOfHitCells) {
    super(numOfHitCells);
    this.size = 3;
  }

  @Override
  public String getShipType() {
    return "Cruiser";
  }

  public Ship hitShip() {
    return new Cruiser(getNumOfHitCells() + 1);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "Cruiser. Size: "
            + getSize()
            + " Cells";
  }
}
