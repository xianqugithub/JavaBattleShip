package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class OpenSeaWaterCellTest {

  private OpenSeaWaterCell openSeaWaterCell;
  private OpenSeaWaterCell openSeaWaterCellHit;

  @Before
  public void setUp() throws Exception {
    openSeaWaterCell = new OpenSeaWaterCell(false);
    openSeaWaterCellHit = new OpenSeaWaterCell(true);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertTrue(openSeaWaterCellHit.placeShipOnCell());
    Assert.assertTrue(openSeaWaterCell.placeShipOnCell());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(openSeaWaterCell.attackCell(), openSeaWaterCellHit);
  }

  @Test
  public void prettyPrint() {
    openSeaWaterCell.prettyPrint(new Printer());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(openSeaWaterCell, openSeaWaterCell);
    Assert.assertEquals(openSeaWaterCellHit, openSeaWaterCellHit);
    Assert.assertNotEquals(openSeaWaterCellHit, openSeaWaterCell);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(openSeaWaterCell.hashCode(), openSeaWaterCell.hashCode());
    Assert.assertEquals(openSeaWaterCellHit.hashCode(), openSeaWaterCellHit.hashCode());
    Assert.assertNotEquals(openSeaWaterCellHit.hashCode(), openSeaWaterCell.hashCode());

  }
}