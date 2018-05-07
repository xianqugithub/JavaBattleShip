package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

/**
 * Represents the ship placer.
 */
public interface ShipPlacer {
  /**
   * Creator of a new random ship placer.
   *
   * @return a new random ship placer.
   */
  static ShipPlacer createRandomShipPlacer() {
    return new RandomShipPlacer();
  }

  /**
   * Creator of a new manual ship placer.
   *
   * @return a new manual ship placer.
   */
  static ShipPlacer createManualShipPlacer() {
    return new ManualShipPlacer();
  }

  /**
   * Place ships of a specific player.
   *
   * @param player whose ships are to be placed.
   */
  void placeShips(Player player);
}
