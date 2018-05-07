package edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AttackResultTest {

  private AttackResult missResult;
  private AttackResult hitResult;
  private AttackResult sunkResult;

  @Before
  public void setUp() throws Exception {
    missResult = new Miss();
    hitResult = new Hit();
    sunkResult = new Sunk();
  }

  @Test
  public void result() {
    Assert.assertEquals(missResult.result(), "Miss");
    Assert.assertEquals(hitResult.result(), "Hit");
    Assert.assertEquals(sunkResult.result(), "Sunk");
  }

  @Test
  public void createHit() {
    Assert.assertEquals(AttackResult.createHit(), hitResult);
  }

  @Test
  public void createMiss() {
    Assert.assertEquals(AttackResult.createMiss(), missResult);
  }

  @Test
  public void createSunk() {
    Assert.assertEquals(AttackResult.createSunk(), sunkResult);
  }
}