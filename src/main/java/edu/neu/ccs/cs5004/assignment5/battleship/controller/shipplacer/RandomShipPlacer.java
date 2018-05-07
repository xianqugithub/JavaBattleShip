package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.ShipConfiguration;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

import java.util.Random;

public class RandomShipPlacer extends AbstractShipPlacer {

  private Random rand;

  RandomShipPlacer() {
    rand = new Random();
  }

  @Override
  public void placeShips(Player player) {
    Map fleetMap = player.getFleetMap();
    Ship[] ships = player.getShips();

    int index = 0;
    while (index < ships.length) {
      Ship curShip = ships[index];
      Row row = Row.values()[rand.nextInt(10)];
      Col col = Col.values()[rand.nextInt(10)];
      ShipConfiguration configuration = ShipConfiguration.values()[rand.nextInt(10) / 5];

      if (isValidLocation(row, col, configuration, curShip.getSize(), fleetMap)) {
        placeSingleShip(row, col, configuration, curShip, fleetMap);
        index++;
      }
    }

  }




}
