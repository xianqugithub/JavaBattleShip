package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents the destroyer.
 */
class Destroyer extends AbstractShip {
  Destroyer(Integer numOfHitCells) {
    super(numOfHitCells);
    this.size = 1;
  }

  @Override
  public String getShipType() {
    return "Destroyer";
  }

  public Ship hitShip() {
    return new Destroyer(getNumOfHitCells() + 1);
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
    return "Destroyer. Size: "
            + getSize()
            + " Cells";
  }


}
