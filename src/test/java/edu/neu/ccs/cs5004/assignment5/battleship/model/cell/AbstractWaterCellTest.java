package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;

import static org.junit.Assert.*;

public class AbstractWaterCellTest {

  private AbstractWaterCell gapWaterCell;
  private AbstractWaterCell openSeaWaterCell;

  @Before
  public void setUp() throws Exception {
    gapWaterCell = new GapWaterCell(false);
    openSeaWaterCell = new OpenSeaWaterCell(false);
  }

  @Test
  public void hasShip() {
    Assert.assertFalse(gapWaterCell.hasShip());
    Assert.assertFalse(openSeaWaterCell.hasShip());
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(gapWaterCell.attackResult(), AttackResult.createMiss());
    Assert.assertEquals(openSeaWaterCell.attackResult(), AttackResult.createMiss());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(gapWaterCell, gapWaterCell);
    Assert.assertEquals(openSeaWaterCell, openSeaWaterCell);
    Assert.assertNotEquals(gapWaterCell, openSeaWaterCell);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(gapWaterCell.hashCode(), gapWaterCell.hashCode());
    Assert.assertEquals(openSeaWaterCell.hashCode(), openSeaWaterCell.hashCode());
    Assert.assertNotEquals(gapWaterCell.hashCode(), openSeaWaterCell.hashCode());
  }
}