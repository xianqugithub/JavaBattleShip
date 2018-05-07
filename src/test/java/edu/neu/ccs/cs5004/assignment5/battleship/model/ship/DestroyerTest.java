package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestroyerTest {

  private Destroyer destroyer;
  private Destroyer anotherDestroyer;
  private Destroyer diffDestroyer;
  private Destroyer nullDestroyer;
  private Battleship battleship;

  @Before
  public void setUp() throws Exception {
    destroyer = new Destroyer(3);
    anotherDestroyer = new Destroyer(3);
    diffDestroyer = new Destroyer(2);
    nullDestroyer = null;
    battleship = new Battleship(2);
  }

  @Test
  public void getShipType() {
    Assert.assertEquals("Destroyer", destroyer.getShipType());
  }

  @Test
  public void hitShip() {
    Assert.assertEquals(diffDestroyer.hitShip(), destroyer);
  }

  @Test
  public void equals() {
    Assert.assertEquals(destroyer, destroyer);
    Assert.assertEquals(destroyer, anotherDestroyer);
    Assert.assertNotEquals(destroyer, diffDestroyer);
    Assert.assertNotEquals(destroyer, nullDestroyer);
    Assert.assertNotEquals(destroyer, battleship);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(destroyer.hashCode(), destroyer.hashCode());
    Assert.assertEquals(destroyer.hashCode(), anotherDestroyer.hashCode());
    Assert.assertNotEquals(destroyer.hashCode(), diffDestroyer.hashCode());
    Assert.assertNotEquals(destroyer.hashCode(), battleship.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Destroyer. Size: 1 Cells", destroyer.toString());
  }
}