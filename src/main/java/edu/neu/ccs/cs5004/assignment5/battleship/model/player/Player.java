package edu.neu.ccs.cs5004.assignment5.battleship.model.player;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Col;
import edu.neu.ccs.cs5004.assignment5.battleship.model.enumparameters.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;



public interface Player {

  /**
   * Creator of new human player.
   *
   * @param ships that are given to the human player.
   * @return a new human player.
   */
  static Player createHumanPlayer(Ship[] ships) {
    return new HumanPlayer(ships);
  }

  /**
   * Creator of new computer player.
   *
   * @param ships that are given to the computer player.
   * @return a new computer player.
   */
  static Player createComputerPlayer(Ship[] ships) {
    return new ComputerPlayer(ships);
  }

  /**
   * Attack of enemy at specific position.
   *
   * @param enemy the player to be attacked.
   * @param row the attacked row number [1-10].
   * @param col the attacked col number [A-J].
   */
  void attackEnemy(Player enemy, Row row, Col col);

  /**
   * Attacked at specific position.
   *
   * @param row the attacked row number [1-10].
   * @param col the attacked col number [A-J].
   */
  void attacked(Row row, Col col);

  /**
   * Attack Result after attacked at specific position.
   *
   * @param row the attacked row number [1-10].
   * @param col the attacked col number [A-J].
   * @return the attacked response.
   */
  AttackResult attackResponse(Row row, Col col);

  /**
   * If this player is lost.
   *
   * @return a boolean variable that indicates if the current player is lost.
   */
  Boolean isLost();

  /**
   * Getter of current player's fleet map.
   *
   * @return the player's fleet map.
   */
  Map getFleetMap();

  /**
   * Getter of current player's guess map.
   *
   * @return the player's guess map.
   */
  Map getGuessMap();

  /**
   * Getter of current player's ships.
   *
   * @return the ships that are originally assigned to the player.
   */
  Ship[] getShips();

  /**
   * Getter of current player's number of ships.
   *
   * @return the number of ships.
   */
  int getNumOfShips();

  /**
   * Getter if current player can attack.
   *
   * @return if the current player can attack its opponent.
   */
  boolean canAttack();

  /**
   * Mutator of current player's attack status.
   */
  void resetAttack();


}
