package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents the submarine.
 */
class Submarine extends AbstractShip {
  Submarine(Integer numOfHitCells) {
    super(numOfHitCells);
    this.size = 2;
  }

  @Override
  public String getShipType() {
    return "Submarine";
  }

  public Ship hitShip() {
    return new Submarine(getNumOfHitCells() + 1);
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
    return "Submarine. Size: "
            + getSize()
            + " Cells";
  }


}
