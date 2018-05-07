package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

/**
 * Represent the regular mode of game.
 */
public class GameMode extends AbstractGame {
  GameMode() {
    Ship[] ships = new Ship[10];
    final int numOfBattleship = 1;
    final int numOfCruiser = 2;
    final int numOfSubmarine = 3;
    final int numOfDestroyer = 4;
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
