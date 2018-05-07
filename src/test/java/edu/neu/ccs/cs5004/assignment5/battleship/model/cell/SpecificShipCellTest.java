package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.Battleship;
import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class SpecificShipCellTest {

  private SpecificShipCell specificShipCell;

  @Before
  public void setUp() throws Exception {
    specificShipCell = new SpecificShipCell(false, false, Ship.createBattleShip());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(specificShipCell.attackCell(), new SpecificShipCell(true, false, Ship.createBattleShip().hitShip()));
  }

  @Test
  public void updateTheShip() {
    Assert.assertEquals(specificShipCell.updateTheShip(), new SpecificShipCell(false, false, Ship.createBattleShip().hitShip()));
    Assert.assertEquals(specificShipCell.attackCell().attackCell().attackCell().updateTheShip(), new SpecificShipCell(true, true, Ship.createBattleShip().hitShip().hitShip().hitShip().hitShip()));

  }

  @Test
  public void attackResult() {
    Assert.assertEquals(specificShipCell.attackResult(), AttackResult.createHit());
    Assert.assertEquals(specificShipCell.attackCell().attackCell().attackCell().attackResult(), AttackResult.createSunk());
  }

  @Test
  public void prettyPrint() {
    specificShipCell.prettyPrint(new Printer());
  }

  @Test
  public void getShip() {
    Assert.assertEquals(specificShipCell.getShip(), Ship.createBattleShip());
  }
}