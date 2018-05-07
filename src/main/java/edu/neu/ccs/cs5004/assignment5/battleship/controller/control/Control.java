package edu.neu.ccs.cs5004.assignment5.battleship.controller.control;

/**
 * Represents the game control.
 */
public interface Control {

  /**
   * creates a new game.
   *
   * @return a new game control class.
   */
  static Control createGameControl() {
    return new GameControl();
  }

  /**
   * Starts a new game.
   */
  void gameStart();
}
