package edu.neu.ccs.cs5004.assignment5.battleship.view.observer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.game.Game;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;

/**
 * Represent an observer interface.
 */
public interface Observer {

  /**
   * Update the game.
   * @param game the game to be updated.
   */
  void update(Game game);

  /**
   * Update the map.
   * @param map the map to be updated.
   */
  void update(Map map);

  /**
   * Creator of a new console observer.
   * @return a new console observer.
   */
  static Observer createConsoleObserver() {
    return new ConsoleObserver();
  }
}
