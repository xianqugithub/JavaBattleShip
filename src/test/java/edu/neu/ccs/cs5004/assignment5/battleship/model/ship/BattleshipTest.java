package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleshipTest {
  private Battleship battleship;
  private Battleship anotherBattleship;
  private Battleship diffBattleship;
  private Battleship nullBattleship;
  private Cruiser cruiser;

  @Before
  public void setUp() throws Exception {
    battleship = new Battleship(3);
    anotherBattleship = new Battleship(3);
    diffBattleship = new Battleship(2);
    nullBattleship = null;
    cruiser = new Cruiser(2);
  }

  @Test
  public void getShipType() {
    Assert.assertEquals(battleship.getShipType(), "BattleShip");

  }

  @Test
  public void hitShip() {
    Assert.assertEquals(diffBattleship.hitShip(), battleship);
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(battleship, battleship);
    Assert.assertEquals(battleship, anotherBattleship);
    Assert.assertNotEquals(battleship, diffBattleship);
    Assert.assertNotEquals(battleship, nullBattleship);
    Assert.assertNotEquals(battleship, cruiser);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(battleship.hashCode(), battleship.hashCode());
    Assert.assertEquals(battleship.hashCode(), anotherBattleship.hashCode());
    Assert.assertNotEquals(battleship.hashCode(), diffBattleship.hashCode());
    Assert.assertNotEquals(battleship.hashCode(), cruiser.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("BattleShip. Size: 4 Cells", battleship.toString());
  }
}