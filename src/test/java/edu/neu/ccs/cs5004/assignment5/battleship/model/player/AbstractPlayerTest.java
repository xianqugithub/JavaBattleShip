package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

import static org.junit.Assert.*;

public class AbstractPlayerTest {
  Player example1;
  Player example2;

  @Before
  public void setUp() throws Exception {
    Ship [] ships = new Ship[2];
    ships[0] = Ship.createBattleShip();
    ships[1] = Ship.createCruiser();
    example1 = Player.createHumanPlayer(ships);
    example2 = Player.createComputerPlayer(ships);
  }

  @Test
  public void canAttack() {
    Assert.assertTrue(example1.canAttack());
    Assert.assertTrue(example2.canAttack());
  }

  @Test
  public void getShips() {
    Assert.assertEquals(example1.getShips(),example2.getShips());
  }

  @Test
  public void getFleetMap() {
    Assert.assertEquals(example1.getFleetMap(), Map.createMap());
  }

  @Test
  public void getGuessMap() {
    Assert.assertEquals(example1.getGuessMap(), Map.createMap());
  }

  @Test
  public void getNumOfShips() {
    Assert.assertEquals(example1.getNumOfShips(),2);
  }

  @Test
  public void isLost() {
    Player loser = Player.createHumanPlayer(new Ship[0]);
    Assert.assertEquals(loser.isLost(),true);
    Assert.assertEquals(example1.isLost(),false);
  }

  @Test
  public void attackEnemy() {
    example1.attackEnemy(example2, Row.R1, Col.A);
    Assert.assertEquals(example2.getFleetMap().getPos(Row.R1,Col.A).getIsHit(),true);
    example2.getFleetMap().replaceCell(Row.R3,Col.A,Cell.createSpecificShipCell(Ship.createCruiser()));
    example2.getFleetMap().replaceCell(Row.R3,Col.B,Cell.createSpecificShipCell(Ship.createCruiser()));
    example2.getFleetMap().replaceCell(Row.R3,Col.C,Cell.createSpecificShipCell(Ship.createCruiser()));
    example1.attackEnemy(example2,Row.R3,Col.B);
    example2.getFleetMap().replaceCell(Row.R1,Col.D,Cell.createSpecificShipCell(Ship.createCruiser()));
    example2.getFleetMap().replaceCell(Row.R2,Col.D,Cell.createSpecificShipCell(Ship.createCruiser()));
    example2.getFleetMap().replaceCell(Row.R3,Col.D,Cell.createSpecificShipCell(Ship.createCruiser()));
    example1.attackEnemy(example2,Row.R2,Col.D);
    Assert.assertEquals(example2.getFleetMap().getPos(Row.R3,Col.A).getIsHit(),false);
  }

  @Test
  public void attacked() {
    example1.attacked(Row.R1,Col.A);
    Assert.assertEquals(example1.getFleetMap().getPos(Row.R1,Col.A).getIsHit(),true);
  }

  @Test
  public void attackResponse() {
    Assert.assertEquals(example1.attackResponse(Row.R2, Col.B), AttackResult.createMiss());
    example1.getFleetMap().replaceCell(Row.R3,Col.B, Cell.createSpecificShipCell(Ship.createBattleShip()));
    example1.getFleetMap().replaceCell(Row.R3,Col.C, Cell.createSpecificShipCell(Ship.createDestroyer()));
    Assert.assertEquals(example1.attackResponse(Row.R3, Col.B), AttackResult.createHit());
    Assert.assertEquals(example1.attackResponse(Row.R3, Col.C), AttackResult.createSunk());
  }

  @Test
  public void resetAttack() {
    example1.resetAttack();
    Assert.assertEquals(example1.canAttack(),true);
    Assert.assertEquals(example2.canAttack(),true);
  }
}