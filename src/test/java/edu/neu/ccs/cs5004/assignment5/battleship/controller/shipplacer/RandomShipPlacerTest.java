package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

import static org.junit.Assert.*;

public class RandomShipPlacerTest {
  private ShipPlacer sp;
  private Player p1;
  @Before
  public void setUp()  {
    sp = new RandomShipPlacer();
    p1 = Player.createComputerPlayer(new Ship[]{Ship.createBattleShip(),
        Ship.createBattleShip(),Ship.createBattleShip(),Ship.createBattleShip()});
  }

  @Test
  public void placeShips() {
    sp.placeShips(p1);
  }
}