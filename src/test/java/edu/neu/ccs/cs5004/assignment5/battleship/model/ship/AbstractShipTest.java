package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractShipTest {

  private AbstractShip ship;
  private AbstractShip sameRefShip;
  private AbstractShip sameStateShip;
  private AbstractShip yetAnotherShip;
  private AbstractShip diffShip;
  private AbstractShip nullShip;

  @Before
  public void setUp() throws Exception {
    ship = new Cruiser(2);
    sameRefShip = ship;
    sameStateShip = new Cruiser(2);
    yetAnotherShip = new Cruiser(2);
    diffShip = new Battleship(4);
    nullShip = null;
  }

  @Test
  public void getSize() {
    Assert.assertEquals(new Integer(3), ship.getSize());
    Assert.assertEquals(new Integer(4), diffShip.getSize());
  }

  @Test
  public void getNumOfHitCells() {
    Assert.assertEquals(new Integer(2), ship.getNumOfHitCells());
    Assert.assertEquals(new Integer(4), diffShip.getNumOfHitCells());
  }

  @Test
  public void isSunk() {
    Assert.assertTrue(diffShip.isSunk());
    Assert.assertFalse(ship.isSunk());
  }

  @Test
  public void testEquals() {
    Assert.assertEquals(ship, ship);
    Assert.assertEquals(ship, sameRefShip);
    Assert.assertTrue(ship.equals(sameStateShip));
    Assert.assertTrue(sameStateShip.equals(ship));
    Assert.assertEquals(ship.equals(sameStateShip), sameStateShip.equals(ship));
    Assert.assertEquals(ship.equals(sameStateShip) && sameStateShip.equals(yetAnotherShip),
            yetAnotherShip.equals(ship));
    Assert.assertFalse(ship.equals(nullShip));
    Assert.assertNotEquals(ship, diffShip);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(ship.equals(sameRefShip), ship.hashCode() == sameRefShip.hashCode());
    Assert.assertNotEquals(ship.hashCode(), diffShip.hashCode());
    Assert.assertEquals(ship.hashCode(), yetAnotherShip.hashCode());
  }

}