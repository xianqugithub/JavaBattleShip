package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents the Battleship.
 */
class Battleship extends AbstractShip {
  Battleship(Integer numOfHitCells) {
    super(numOfHitCells);
    this.size = 4;
  }

  @Override
  public String getShipType() {
    return "BattleShip";
  }

  public Ship hitShip() {
    return new Battleship(getNumOfHitCells() + 1);
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
    return "BattleShip. Size: "
            + getSize()
            + " Cells";
  }
}
