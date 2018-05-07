package edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitTest {
  private Hit hit;
  private Hit sameRefHit;
  private Hit sameStateHit;
  private Hit yetAnotherHit;
  private Hit nullHit;

  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    sameRefHit = hit;
    sameStateHit = new Hit();
    yetAnotherHit = new Hit();
    nullHit = null;
  }

  @Test
  public void result() {
    Assert.assertEquals("Hit", hit.result());
  }


  @Test
  public void testHashCode() {
    Assert.assertEquals(hit.equals(sameRefHit), hit.hashCode() == sameRefHit.hashCode());
    Assert.assertEquals(hit.equals(sameStateHit), hit.hashCode() == sameStateHit.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(hit.equals(hit));
    Assert.assertTrue(hit.equals(sameRefHit));
    Assert.assertTrue(hit.equals(sameStateHit));
    Assert.assertTrue(sameStateHit.equals(hit));
    Assert.assertEquals(hit.equals(sameStateHit), sameStateHit.equals(hit));
    Assert.assertEquals(hit.equals(sameStateHit) && sameStateHit.equals(yetAnotherHit),
            yetAnotherHit.equals(hit));
    Assert.assertFalse(hit.equals(nullHit));
  }
}