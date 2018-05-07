package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;

import java.io.IOException;

/**
 * Represent a battleship game interface.
 */
public interface Game {
  /**
   * Start a new game.
   */
  static Game createGameMode() {
    Game game = new GameMode();
    game.initialize();
    return game;
  }

  /**
   * Start a debug game.
   */
  static Game createDebugMode() throws IOException {
    Game game = new DebugMode();
    game.initialize();
    return game;
  }

  /**
   * Initialize a game.
   */
  void initialize();

  /**
   * Getter for player 1.
   *
   * @return the player 1.
   */
  Player getPlayer1();

  /**
   * Getter for player 2.
   *
   * @return the player 2.
   */
  Player getPlayer2();

  /**
   * Print the current game.
   *
   * @param printer the printer used to print the game.
   */
  void prettyPrint(ConsolePrinter printer);
}
