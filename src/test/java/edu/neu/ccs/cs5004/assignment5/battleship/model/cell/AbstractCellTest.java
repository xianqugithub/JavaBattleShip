package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractCellTest {

  private AbstractCell enemyShipCell;
  private AbstractCell openSeaWaterCell;

  @Before
  public void setUp() throws Exception {
    enemyShipCell = new EnemyShipCell(false, false);
    openSeaWaterCell = new OpenSeaWaterCell(true);
  }

  @Test
  public void getIsHit() {
    Assert.assertFalse(enemyShipCell.getIsHit());
    Assert.assertTrue(openSeaWaterCell.getIsHit());
  }

  @Test
  public void updateTheShip() {
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(enemyShipCell, enemyShipCell);
    Assert.assertEquals(openSeaWaterCell, openSeaWaterCell);
    Assert.assertNotEquals(enemyShipCell, openSeaWaterCell);
    Assert.assertNotEquals(enemyShipCell, null);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(enemyShipCell.hashCode(), enemyShipCell.hashCode());
    Assert.assertEquals(openSeaWaterCell.hashCode(), openSeaWaterCell.hashCode());
    Assert.assertNotEquals(enemyShipCell.hashCode(), openSeaWaterCell.hashCode());
  }
}