package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractShipCellTest {

  private AbstractShipCell abstractShipCell;

  @Before
  public void setUp() throws Exception {
    abstractShipCell = new EnemyShipCell(false, false);
  }

  @Test
  public void getIsSunk() {
    Assert.assertFalse(abstractShipCell.getIsSunk());
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertFalse(abstractShipCell.placeShipOnCell());
  }

  @Test
  public void hasShip() {
    Assert.assertTrue(abstractShipCell.hasShip());
  }
}