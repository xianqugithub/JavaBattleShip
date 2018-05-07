package edu.neu.ccs.cs5004.assignment5.battleship.model.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

import static org.junit.Assert.*;

public class PlayerMapTest {
  private Map example;
  private Map sameExample;
  private Map sameStateExample;
  private Map anotherExample;
  private Map diffExample;
  private Map nullExample;
  @Before
  public void setUp() throws Exception {
    example = Map.createMap();
    sameExample = example;
    sameStateExample = Map.createMap();
    anotherExample = Map.createMap();
    diffExample = Map.createMap();
    diffExample.replaceCell(Row.R1,Col.J,Cell.createGapWaterCell());
    nullExample = null;
  }

  @Test
  public void getPos() {
    Assert.assertEquals(example.getPos(Row.R2, Col.H), Cell.createOpenSeaWaterCell());
  }

  @Test
  public void replaceCell() {
    example.replaceCell(Row.R2,Col.H,Cell.createGapWaterCell());
    Assert.assertEquals(example.getPos(Row.R2,Col.H),Cell.createGapWaterCell());
  }

  @Test
  public void prettyPrint() {
    example.prettyPrint(new Printer());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(example.equals(example));
    Assert.assertTrue(example.equals(sameExample));
    Assert.assertTrue(example.equals(sameStateExample));
    Assert.assertTrue(sameStateExample.equals(example));
    Assert.assertEquals(example.equals(sameStateExample), sameStateExample.equals(example));
    Assert.assertEquals(example.equals(sameStateExample) && sameStateExample.equals(anotherExample),
        anotherExample.equals(example));
    Assert.assertFalse(example.equals(nullExample));
    Assert.assertNotEquals(example, diffExample);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(example.equals(sameExample), example.hashCode() == sameExample.hashCode());
  }
}