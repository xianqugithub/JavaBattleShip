package edu.neu.ccs.cs5004.assignment5.battleship.controller.strategy;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

import static org.junit.Assert.*;

public class RandomStrategyTest {
  Strategy s;
  Player player1;
  Player player2;
  @Before
  public void setUp() throws Exception {
    s = Strategy.createRandomStrategy();
    player1 = Player.createHumanPlayer(new Ship[] {Ship.createBattleShip()});
    player2 = Player.createHumanPlayer(new Ship[] {Ship.createBattleShip()});
  }

  @Test
  public void attackEnemy() {
    s.attackEnemy(player1,player2);
    s.attackEnemy(player2,player1);
  }
}