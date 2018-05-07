package edu.neu.ccs.cs5004.assignment5.battleship.controller.shipplacer;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class AbstractShipPlacerTest {
  ShipPlacer sp;
  Map example5;
  Player player1;
  @Before
  public void setUp() throws Exception {
    sp = ShipPlacer.createRandomShipPlacer();
    example5 =Map.createMap();
    player1 = Player.createComputerPlayer(new Ship[]{Ship.createBattleShip()});
  }

  @Test
  public void placeSingleShip() {
    sp.placeShips(player1);
  }
}