package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents the abstract ship in the program.
 */
abstract class AbstractShip implements Ship {

  private Integer numOfHitCells;
  Integer size;

  /**
   * Instantiate an abstract ship.
   *
   * @param numOfHitCells the number of cells that have been hit.
   */
  AbstractShip(Integer numOfHitCells) {
    this.numOfHitCells = numOfHitCells;
  }


  public Integer getSize() {
    return this.size;
  }

  /**
   * Getter for the property 'numOfHitCells'.
   *
   * @return Value for property 'numOfHitCells'.
   */
  Integer getNumOfHitCells() {
    return this.numOfHitCells;
  }

  public Boolean isSunk() {
    return getSize() - getNumOfHitCells() <= 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractShip abstractShip = (AbstractShip) obj;

    if (!getSize().equals(abstractShip.getSize())) {
      return false;
    }

    return getNumOfHitCells().equals(abstractShip.getNumOfHitCells());

  }

  @Override
  public int hashCode() {
    int result = this.numOfHitCells != null ? this.numOfHitCells.hashCode() : 0;
    result = 31 * result + (this.size != null ? this.size.hashCode() : 0);
    return result;
  }

}
