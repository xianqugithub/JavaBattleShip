package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

/**
 * Represents the ship interface in the program.
 */
public interface Ship {

  /**
   * Creator of a new Battle Ship.
   * @return a new Battle Ship.
   */
  static Ship createBattleShip() {
    return new Battleship(0);
  }

  /**
   * Creator of a new Cruiser.
   * @return a new Cruiser.
   */
  static Ship createCruiser() {
    return new Cruiser(0);
  }

  /**
   * Creator of a new Destroyer.
   * @return a new Destroyer.
   */
  static Ship createDestroyer() {
    return new Destroyer(0);
  }

  /**
   * Creator of a new Submarine.
   * @return a new Submarine.
   */
  static Ship createSubmarine() {
    return new Submarine(0);
  }

  /**
   * Getter of current ship's type.
   *
   * @return the ship's type in string format.
   */
  String getShipType();

  /**
   * Hit the current ship.
   *
   * @return a new ship after the hit.
   */
  Ship hitShip();

  /**
   * If the current ship is sunk.
   *
   * @return if current ship is sunk.
   */
  Boolean isSunk();

  /**
   * Getter for the property 'size'.
   *
   * @return Value for property 'size'.
   */
  Integer getSize();
}
