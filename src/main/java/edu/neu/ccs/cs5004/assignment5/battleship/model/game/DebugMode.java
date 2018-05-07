package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Represent the debug mode of game.
 */
public class DebugMode extends AbstractGame {
  DebugMode() throws IOException {

    int numOfBattleship = 0;
    int numOfCruiser = 0;
    int numOfSubmarine = 0;
    int numOfDestroyer = 0;

    String battleShipInput;
    String cruiserInput;
    String submarineInput;
    String destroyerInput;

    System.out.println("This is the debug mode.");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in,
            StandardCharsets.UTF_8));

    try {
      do {
        System.out.println("Please enter the number of battleship.");
        System.out.println("Can not be less than 0 or more than 1.");
        battleShipInput = bufferedReader.readLine();
      }
      while ((battleShipInput != null) && (!battleShipInput.equals("0") && (!battleShipInput
              .equals("1"))));

      if (battleShipInput != null) {
        numOfBattleship = Integer.parseInt(battleShipInput);
      }

      do {
        System.out.println("Please enter the number of cruiser.");
        System.out.println("Can not be less than 0 or more than 2.");
        cruiserInput = bufferedReader.readLine();
      }
      while (cruiserInput != null && ((cruiserInput.length() > 1 || cruiserInput.compareTo("0")
              < 0 || cruiserInput.compareTo("2") > 0)));
      if (cruiserInput != null) {
        numOfCruiser = Integer.parseInt(cruiserInput);
      }

      do {
        System.out.println("Please enter the number of submarine.");
        System.out.println("Can not be less than 0 or more than 3.");
        submarineInput = bufferedReader.readLine();
      }
      while (submarineInput != null && ((submarineInput.length() > 1 || submarineInput.compareTo(
              "0") < 0 || submarineInput.compareTo("3") > 0)));
      if (submarineInput != null) {
        numOfSubmarine = Integer.parseInt(submarineInput);
      }


      do {
        System.out.println("Please enter the number of destroyer.");
        System.out.println("Can not be less than 0 or more than 4.");
        destroyerInput = bufferedReader.readLine();
      }
      while (destroyerInput != null && ((destroyerInput.length() > 1 || destroyerInput.compareTo(
              "0") < 0 || destroyerInput.compareTo("4") > 0)));
      if (destroyerInput != null) {
        numOfDestroyer = Integer.parseInt(destroyerInput);
      }

    } catch (IOException e) {
      System.out.println("Exception thrown during deciding number of ships");
    }

    Ship[] ships = new Ship[numOfBattleship + numOfCruiser + numOfSubmarine + numOfDestroyer];
    int index = 0;
    for (int i = 0; i < numOfBattleship; i++) {
      ships[index] = Ship.createBattleShip();
      index++;
    }
    for (int i = 0; i < numOfCruiser; i++) {
      ships[index] = Ship.createCruiser();
      index++;
    }
    for (int i = 0; i < numOfSubmarine; i++) {
      ships[index] = Ship.createSubmarine();
      index++;
    }
    for (int i = 0; i < numOfDestroyer; i++) {
      ships[index] = Ship.createDestroyer();
      index++;
    }
    this.player1 = Player.createHumanPlayer(ships);
    this.player2 = Player.createComputerPlayer(ships);
  }

  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }

}
