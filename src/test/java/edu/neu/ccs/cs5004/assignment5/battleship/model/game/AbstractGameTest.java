package edu.neu.ccs.cs5004.assignment5.battleship.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import static org.junit.Assert.*;

public class AbstractGameTest {

  private AbstractGame game;

  @Before
  public void setUp() throws Exception {
    game = new GameMode();
  }

  @Test
  public void getPlayer1() {
    game.getPlayer1();
  }

  @Test
  public void getPlayer2() {
    game.getPlayer2();
  }

  @Test
  public void initialize() {

    ByteArrayInputStream in = new ByteArrayInputStream("R".getBytes());
    System.setIn(in);
    game.initialize();
    System.setIn(System.in);

  }
}