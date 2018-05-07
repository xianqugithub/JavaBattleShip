package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

import static org.junit.Assert.*;

public class ManualShipPlacerTest {
  private ShipPlacer sp;
  private Player p1;
  @Before
  public void setUp() throws Exception {
    sp = new RandomShipPlacer();
    p1 = Player.createHumanPlayer(new Ship[]{Ship.createBattleShip(),
        Ship.createBattleShip(),Ship.createBattleShip(),Ship.createBattleShip()});
  }

  @Test
  public void placeShips() {
  }
}