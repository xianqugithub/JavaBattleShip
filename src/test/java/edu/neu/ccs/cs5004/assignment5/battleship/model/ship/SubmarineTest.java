package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarineTest {

  private Submarine submarine;
  private Submarine anotherSubmarine;
  private Submarine diffSubmarine;
  private Submarine nullSubmarine;
  private Battleship battleship;

  @Before
  public void setUp() throws Exception {
    submarine = new Submarine(3);
    anotherSubmarine = new Submarine(3);
    diffSubmarine = new Submarine(2);
    nullSubmarine = null;
    battleship = new Battleship(2);
  }

  @Test
  public void getShipType() {
    Assert.assertEquals("Submarine", submarine.getShipType());
  }

  @Test
  public void hitShip() {
    Assert.assertEquals(diffSubmarine.hitShip(), submarine);
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(submarine, submarine);
    Assert.assertEquals(submarine, anotherSubmarine);
    Assert.assertNotEquals(submarine, diffSubmarine);
    Assert.assertNotEquals(submarine, nullSubmarine);
    Assert.assertNotEquals(submarine, battleship);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(submarine.hashCode(), submarine.hashCode());
    Assert.assertEquals(submarine.hashCode(), anotherSubmarine.hashCode());
    Assert.assertNotEquals(submarine.hashCode(), diffSubmarine.hashCode());
    Assert.assertNotEquals(submarine.hashCode(), battleship.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Submarine. Size: 2 Cells", submarine.toString());
  }
}