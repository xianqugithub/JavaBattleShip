package edu.neu.ccs.cs5004.assignment5.battleship.controller.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;

/**
 * Represents the abstract strategy.
 */
abstract class AbstractStrategy implements Strategy {

  /**
   * Getter for current cell's validity for attack.
   *
   * @param guessMap the guess map of current player.
   * @param row the row number [1-10].
   * @param col the col number [A-J].
   * @return if the current position if valid.
   */
  boolean isValidPosition(Map guessMap, Row row, Col col) {
    return !guessMap.getPos(row, col).getIsHit();
  }


}
