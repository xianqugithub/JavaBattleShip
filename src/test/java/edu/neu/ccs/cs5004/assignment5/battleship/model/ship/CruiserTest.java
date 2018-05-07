package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CruiserTest {

  private Cruiser cruiser;
  private Cruiser anotherCruiser;
  private Cruiser diffCruiser;
  private Cruiser nullCruiser;
  private Battleship battleship;

  @Before
  public void setUp() throws Exception {
    cruiser = new Cruiser(3);
    anotherCruiser = new Cruiser(3);
    diffCruiser = new Cruiser(2);
    nullCruiser = null;
    battleship = new Battleship(2);
  }

  @Test
  public void getShipType() {
    Assert.assertEquals(cruiser.getShipType(), "Cruiser");
  }

  @Test
  public void hitShip() {
    Assert.assertEquals(diffCruiser.hitShip(), cruiser);
  }

  @Test
  public void equals() {
    Assert.assertEquals(cruiser, cruiser);
    Assert.assertEquals(cruiser, anotherCruiser);
    Assert.assertNotEquals(cruiser, diffCruiser);
    Assert.assertNotEquals(cruiser, nullCruiser);
    Assert.assertNotEquals(battleship, cruiser);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cruiser.hashCode(), cruiser.hashCode());
    Assert.assertEquals(cruiser.hashCode(), anotherCruiser.hashCode());
    Assert.assertNotEquals(cruiser.hashCode(), diffCruiser.hashCode());
    Assert.assertNotEquals(cruiser.hashCode(), battleship.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Cruiser. Size: 3 Cells", cruiser.toString());
  }
}