package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer.ShipPlacer;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Represent a abstract game.
 */
abstract class AbstractGame implements Game {
  Player player1;
  Player player2;

  @Override
  public Player getPlayer1() {
    return player1;
  }

  @Override
  public Player getPlayer2() {
    return player2;
  }

  @Override
  public void initialize() {

    ShipPlacer humanShipPlacer;
    final ShipPlacer computerShipPlacer;
    String input;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in,
            StandardCharsets.UTF_8));
    System.out.println("Press M For Manual Setup of Ships.");
    System.out.println("Press R For Random Setup of Ships.");

    try {
      input = bufferedReader.readLine();

      while ((input != null) && (!input.equals("M") && !input.equals("R"))) {
        System.out.println("Wrong Input.");
        System.out.println("Press M For Manual Setup of Ships.");
        System.out.println("Press R For Random Setup of Ships.");
        input = bufferedReader.readLine();
      }
      if (input == null) {
        input = "";
      }
      switch (input) {
        case "M":
          humanShipPlacer = ShipPlacer.createManualShipPlacer();
          humanShipPlacer.placeShips(player1);
          break;
        case "R":
          humanShipPlacer = ShipPlacer.createRandomShipPlacer();
          humanShipPlacer.placeShips(player1);
          break;
        default:
      }
    } catch (IOException e) {
      System.out.println("The input is not valid.");
    }

    computerShipPlacer = ShipPlacer.createRandomShipPlacer();

    computerShipPlacer.placeShips(player2);
  }
}
