package edu.neu.ccs.cs5004.assignment5.battleship.controller.control;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.strategy.Strategy;
import edu.neu.ccs.cs5004.assignment5.battleship.model.game.Game;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observable.Observable;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observer.Observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Represents a new game control.
 */
public class GameControl implements Control {
  private Game game;

  /**
   * Starts a new game from the controller.
   */
  public void gameStart() {

    Observer consoleObserver = Observer.createConsoleObserver();

    Observable gameUpdate = Observable.createGameUpdate(game);

    gameUpdate.subscribeViewers(consoleObserver);

    //create a buffered reader for future use
    InputStreamReader inputStreamReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    try {
      String input = bufferedReader.readLine();

      while (input == null || !input.equals("G") && !input.equals("D")) {
        System.out.println("Wrong Input. Press G for Game Mode. Press D for Debug Mode.");
        input = bufferedReader.readLine();
      }

      switch (input) {
        case "G":
          game = Game.createGameMode();
          break;
        case "D":
          game = Game.createDebugMode();
          break;
        default:
      }
    } catch (IOException e) {
      System.out.println("");
    }

    gameUpdate.updateGame(game);

    // start the attack
    Strategy userAtt = Strategy.createUserStrategy();
    Strategy randomAtt = Strategy.createRandomStrategy();

    //keep attack each other until break
    while (!game.getPlayer1().isLost() && !game.getPlayer2().isLost()) {

      while (game.getPlayer1().canAttack() && !game.getPlayer2().isLost()) {
        userAtt.attackEnemy(game.getPlayer1(), game.getPlayer2());
        gameUpdate.updateGame(game);
      }

      if (game.getPlayer2().isLost()) {
        break;
      }
      game.getPlayer1().resetAttack();

      while (game.getPlayer2().canAttack() && !game.getPlayer1().isLost()) {
        randomAtt.attackEnemy(game.getPlayer2(), game.getPlayer1());
        gameUpdate.updateGame(game);
      }

      if (game.getPlayer1().isLost()) {
        break;
      }
      game.getPlayer2().resetAttack();
    }
  }
}
