package edu.neu.ccs.cs5004.assignment5.battleship.controller.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.util.Random;

/**
 * Represents the random strategy.
 */
public class RandomStrategy extends AbstractStrategy {

  private Row row;
  private Col col;
  private Random rand;

  RandomStrategy() {
    rand = new Random();
    row = Row.values()[rand.nextInt(10)];
    col = Col.values()[rand.nextInt(10)];
  }

  @Override
  public void attackEnemy(Player self, Player enemy) {

    Map guessMap = self.getGuessMap();

    while (!isValidPosition(guessMap, row, col)) {
      row = Row.values()[rand.nextInt(10)];
      col = Col.values()[rand.nextInt(10)];
    }
    self.attackEnemy(enemy, row, col);
  }

}
