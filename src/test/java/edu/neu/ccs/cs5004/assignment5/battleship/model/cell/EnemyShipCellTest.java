package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class EnemyShipCellTest {

  private EnemyShipCell enemyShipCell;

  @Before
  public void setUp() throws Exception {
    enemyShipCell = new EnemyShipCell(true, false);
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(enemyShipCell.attackResult(), AttackResult.createHit());
  }

  @Test
  public void prettyPrint() {
    enemyShipCell.prettyPrint(new Printer());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(enemyShipCell.attackCell(), new EnemyShipCell(true, false));
  }
}