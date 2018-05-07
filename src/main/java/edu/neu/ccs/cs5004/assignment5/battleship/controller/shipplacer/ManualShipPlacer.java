package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.ShipConfiguration;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observable.Observable;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observer.Observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


class ManualShipPlacer extends AbstractShipPlacer {

  private BufferedReader bufferedReader;
  private Observer consoleObserver;


  ManualShipPlacer() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    consoleObserver = Observer.createConsoleObserver();
  }

  @Override
  public void placeShips(Player player) {
    Map fleetMap = player.getFleetMap();
    Ship[] ships = player.getShips();

    Observable mapUpdate;
    mapUpdate = Observable.createMapUpdate(fleetMap);
    mapUpdate.subscribeViewers(consoleObserver);

    String row;
    String col;
    String configuration;

    int leftNumOfShips = ships.length;
    int index = 0;

    while (leftNumOfShips > 0) {

      try {

        while (true) {

          System.out.println("You Are Placing a " + ships[index]);

          do {
            System.out.println("Please Enter the Row Number.");
            row = bufferedReader.readLine();
          } while (row == null
                  || row.length() > 2
                  || (row.length() == 1 && (row.compareTo("1") < 0 || row.compareTo("9") > 0))
                  || (row.length() == 2 && !row.equals("10")));

          do {
            System.out.println("Please Enter the Column Number.");
            col = bufferedReader.readLine();
          }
          while (col == null || col.length() > 1 || col.compareTo("A") < 0 || col.compareTo("J")
                  > 0);

          do {
            System.out.println("Please enter the Configuration.");
            configuration = bufferedReader.readLine();
          }
          while ((configuration != null) && (!configuration.equals("H") && !configuration.equals(
                  "V")));

          if (isValidLocation(Row.values()[Integer.parseInt(row) - 1], Col.valueOf(col),
                  ShipConfiguration.valueOf(configuration), ships[index].getSize(), fleetMap)) {
            placeSingleShip(Row.values()[Integer.parseInt(row) - 1], Col.valueOf(col),
                    ShipConfiguration.valueOf(configuration), ships[index++], fleetMap);

            mapUpdate.updateMap(fleetMap);
            leftNumOfShips--;
            break;

          } else {
            System.out.println("Invalid Input. Please try again.");
          }

        }

      } catch (IOException e) {

        System.out.println("");
      }

    }


  }
}
