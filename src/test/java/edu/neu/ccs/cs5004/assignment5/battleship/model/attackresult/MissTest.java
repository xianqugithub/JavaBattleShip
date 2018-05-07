package edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissTest {

  private Miss miss;
  private Miss sameRefMiss;
  private Miss sameStateMiss;
  private Miss yetAnotherMiss;
  private Miss nullMiss;

  @Before
  public void setUp() throws Exception {
    miss = new Miss();
    sameRefMiss = miss;
    sameStateMiss = new Miss();
    yetAnotherMiss = new Miss();
    nullMiss = null;
  }

  @Test
  public void result() {
    Assert.assertEquals("Miss", miss.result());
  }

  @Test
  public void testhashCode() {
    Assert.assertEquals(miss.equals(sameRefMiss), miss.hashCode() == sameRefMiss.hashCode());
    Assert.assertEquals(miss.equals(sameStateMiss), miss.hashCode() == sameStateMiss.hashCode());
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(miss.equals(miss));
    Assert.assertTrue(miss.equals(sameRefMiss));
    Assert.assertTrue(miss.equals(sameStateMiss));
    Assert.assertTrue(sameStateMiss.equals(miss));
    Assert.assertEquals(miss.equals(sameStateMiss), sameStateMiss.equals(miss));
    Assert.assertEquals(miss.equals(sameStateMiss) && sameStateMiss.equals(yetAnotherMiss),
            yetAnotherMiss.equals(miss));
    Assert.assertFalse(miss.equals(nullMiss));
  }
}