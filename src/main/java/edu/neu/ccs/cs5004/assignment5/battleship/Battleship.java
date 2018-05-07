package edu.neu.ccs.cs5004.assignment5.battleship;

import edu.neu.ccs.cs5004.assignment5.battleship.controller.control.Control;

public class Battleship {
  public static void main(String[] args) {
    Control control = Control.createGameControl();
    control.gameStart();
  }
}
