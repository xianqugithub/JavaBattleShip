package edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SunkTest {

  private Sunk sunk;
  private Sunk sameRefSunk;
  private Sunk sameStateSunk;
  private Sunk yetAnotherSunk;
  private Sunk nullSunk;

  @Before
  public void setUp() throws Exception {
    sunk = new Sunk();
    sameRefSunk = sunk;
    sameStateSunk = new Sunk();
    yetAnotherSunk = new Sunk();
    nullSunk = null;
  }

  @Test
  public void result() {
    Assert.assertEquals("Sunk", sunk.result());
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(sunk.equals(sameRefSunk), sunk.hashCode() == sameRefSunk.hashCode());
    Assert.assertEquals(sunk.equals(sameStateSunk), sunk.hashCode() == sameStateSunk.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(sunk.equals(sunk));
    Assert.assertTrue(sunk.equals(sameRefSunk));
    Assert.assertTrue(sunk.equals(sameStateSunk));
    Assert.assertTrue(sameStateSunk.equals(sunk));
    Assert.assertEquals(sunk.equals(sameStateSunk), sameStateSunk.equals(sunk));
    Assert.assertEquals(sunk.equals(sameStateSunk) && sameStateSunk.equals(yetAnotherSunk),
            yetAnotherSunk.equals(sunk));
    Assert.assertFalse(sunk.equals(nullSunk));
  }
}