package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.ShipConfiguration;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

abstract class AbstractPlayer implements Player {

  private Map fleetMap;
  private Map guessMap;
  private Ship[] ships;
  private int numOfShips;
  private boolean hasOneMoreChance;

  AbstractPlayer(Ship[] ships) {
    guessMap = Map.createMap();
    fleetMap = Map.createMap();
    this.ships = ships;
    this.numOfShips = ships.length;
    hasOneMoreChance = true;
  }

  @Override
  public boolean canAttack() {
    return hasOneMoreChance;
  }

  @Override
  public Ship[] getShips() {
    return this.ships;
  }

  public Map getFleetMap() {
    return this.fleetMap;
  }

  public Map getGuessMap() {
    return this.guessMap;
  }

  public int getNumOfShips() {
    return this.numOfShips;
  }

  /**
   * Reduce the number of ships possessed by current player.
   */
  private void reduceNumOfShips() {
    this.numOfShips--;
  }

  public Boolean isLost() {
    return getNumOfShips() == 0;
  }

  public void attackEnemy(Player enemy, Row row, Col col) {
    AttackResult attackResult = enemy.attackResponse(row, col);
    updateGuessMap(row, col, attackResult);
    enemy.attacked(row, col);
  }

  public void attacked(Row row, Col col) {

    AttackResult attackResult = attackResponse(row, col);
    Cell attackedCell = fleetMap.getPos(row, col);
    fleetMap.replaceCell(row, col, attackedCell.attackCell());

    if (!attackResult.result().equals("Miss")) {
      updateFleetMap(row, col);
      if (attackResult.result().equals("Sunk")) {
        reduceNumOfShips();
      }
    }
  }

  /**
   * Update current player's fleet map after being attacked at specific position.
   *
   * @param row the row number [1-10];
   * @param col the col number [A-J];
   */
  private void updateFleetMap(Row row, Col col) {
    ShipConfiguration configuration = getShipConfiguration(row, col);

    if (configuration == ShipConfiguration.H) {
      int curColLeft = col.ordinal() - 1;
      int curColRight = col.ordinal() + 1;

      while (curColLeft >= 0 && fleetMap.getPos(row, Col.values()[curColLeft]).hasShip()) {
        Cell curCell = fleetMap.getPos(row, Col.values()[curColLeft]);
        fleetMap.replaceCell(row, Col.values()[curColLeft], curCell.updateTheShip());
        curColLeft--;
      }

      while (curColRight < Col.values().length && fleetMap.getPos(row, Col.values()[curColRight])
              .hasShip()) {
        Cell curCell = fleetMap.getPos(row, Col.values()[curColRight]);
        fleetMap.replaceCell(row, Col.values()[curColRight], curCell.updateTheShip());
        curColRight++;
      }

    } else {
      int curRowUp = row.ordinal() - 1;
      int curRowDown = row.ordinal() + 1;

      while (curRowUp >= 0 && fleetMap.getPos(Row.values()[curRowUp], col).hasShip()) {
        Cell curCell = fleetMap.getPos(Row.values()[curRowUp], col);
        fleetMap.replaceCell(Row.values()[curRowUp], col, curCell.updateTheShip());
        curRowUp--;
      }

      while (curRowDown < Row.values().length && fleetMap.getPos(Row.values()[curRowDown], col)
              .hasShip()) {
        Cell curCell = fleetMap.getPos(Row.values()[curRowDown], col);
        fleetMap.replaceCell(Row.values()[curRowDown], col, curCell.updateTheShip());
        curRowDown++;
      }

    }


  }

  /**
   * Getter of ship configuration at specific location.
   *
   * @param row the row number [1-10];
   * @param col the col number [A-J];
   */
  private ShipConfiguration getShipConfiguration(Row row, Col col) {
    if (row.ordinal() > 0 && fleetMap.getPos(Row.values()[row.ordinal() - 1], col).hasShip()) {
      return ShipConfiguration.V;
    } else if (row.ordinal() < Row.values().length - 1 && fleetMap.getPos(Row.values()[row
            .ordinal() + 1], col).hasShip()) {
      return ShipConfiguration.V;
    } else {
      return ShipConfiguration.H;
    }

  }

  @Override
  public AttackResult attackResponse(Row row, Col col) {
    return fleetMap.getPos(row, col).attackResult();
  }

  /**
   * Update current guess map after receiving the response at specific location.
   *
   * @param row          the row number [1-10];
   * @param col          the col number [A-J];
   * @param attackResult the respond of the enemy.
   */
  private void updateGuessMap(Row row, Col col, AttackResult attackResult) {

    if (attackResult.result().equals("Hit") || attackResult.result().equals("Sunk")) {
      guessMap.replaceCell(row, col, Cell.createEnemyShipCell());
    } else {
      guessMap.replaceCell(row, col, Cell.createOpenSeaWaterCell().attackCell());
      hasOneMoreChance = false;
    }
  }

  @Override
  public void resetAttack() {
    this.hasOneMoreChance = true;
  }
}
