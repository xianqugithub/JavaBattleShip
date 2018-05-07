package edu.neu.ccs.cs5004.assignment5.battleship.controller.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

public interface Strategy {

  /**
   * Creator of a new random strategy.
   *
   * @return a new random strategy.
   */
  static Strategy createRandomStrategy() {
    return new RandomStrategy();
  }

  /**
   * Creator of a new user strategy.
   *
   * @return a new user strategy.
   */
  static Strategy createUserStrategy() {
    return new UserStrategy();
  }

  /**
   * Attacks the enemy.
   *
   * @param self the player that initiates the attack.
   * @param enemy the player that is being attacked.
   */
  void attackEnemy(Player self, Player enemy);
}
