package edu.neu.ccs.cs5004.assignment5.battleship.controller.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * Represent the user's strategy.
 */
class UserStrategy extends AbstractStrategy {

  private BufferedReader bufferedReader;
  private String row;
  private String col;

  UserStrategy() {
    bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
  }

  @Override
  public void attackEnemy(Player self, Player enemy) {

    Map guessMap = self.getGuessMap();

    try {

      while (true) {

        do {
          System.out.println("Please enter the row number.");
          row = bufferedReader.readLine();
        }
        while (row == null
                || (row.length() > 2
                || (row.length() == 1 && (row.compareTo("1") < 0 || row.compareTo("9") > 0))
                || (row.length() == 2 && !row.equals("10"))));

        do {
          System.out.println("Please enter the column number.");
          col = bufferedReader.readLine();
        }
        while (col == null || col.length() > 1 || col.compareTo("A") < 0 || col.compareTo("J")
                > 0);

        if (isValidPosition(guessMap, Row.values()[Integer.parseInt(row) - 1], Col.valueOf(col))) {
          break;
        } else {
          System.out.println("Invalid Input. Please try again.");
        }

      }

    } catch (IOException e) {

      System.out.println("");
    }

    self.attackEnemy(enemy, Row.values()[Integer.parseInt(row) - 1], Col.valueOf(col));
  }
}
