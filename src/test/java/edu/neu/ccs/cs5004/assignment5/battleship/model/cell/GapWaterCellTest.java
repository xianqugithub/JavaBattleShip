package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class GapWaterCellTest {

  private GapWaterCell gapWaterCell;
  private GapWaterCell gapWaterCellHit;

  @Before
  public void setUp() throws Exception {
    gapWaterCell = new GapWaterCell(false);
    gapWaterCellHit = new GapWaterCell(true);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertFalse(gapWaterCell.placeShipOnCell());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(gapWaterCell.attackCell(), gapWaterCellHit);
  }

  @Test
  public void prettyPrint() {
    gapWaterCell.prettyPrint(new Printer());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(gapWaterCell, gapWaterCell);
    Assert.assertEquals(gapWaterCellHit, gapWaterCellHit);
    Assert.assertNotEquals(gapWaterCellHit, gapWaterCell);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(gapWaterCell.hashCode(), gapWaterCell.hashCode());
    Assert.assertEquals(gapWaterCellHit.hashCode(), gapWaterCellHit.hashCode());
    Assert.assertNotEquals(gapWaterCellHit, gapWaterCell);


  }
}