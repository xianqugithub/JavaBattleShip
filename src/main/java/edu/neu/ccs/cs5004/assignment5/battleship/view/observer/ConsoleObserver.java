package edu.neu.ccs.cs5004.assignment5.battleship.view.observer;

import edu.neu.ccs.cs5004.assignment5.battleship.model.game.Game;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter.Printer;

public class ConsoleObserver implements Observer {

  @Override
  //print the overall information of this program
  public void update(Game game) {
    if (game == null) {
      System.out.println("");
      System.out.println("Press G for Game Mode. Press D for Debug Mode.");
    } else if (game.getPlayer1().isLost()) {
      System.out.println("***********************************************");
      System.out.println("****************   YOU LOSE  ******************");
      System.out.println("***********************************************");
    } else if (game.getPlayer2().isLost()) {
      System.out.println("***********************************************");
      System.out.println("****************   YOU WIN   ******************");
      System.out.println("***********************************************");
    } else {
      game.prettyPrint(new Printer());
    }
  }

  public void update(Map map) {
    map.prettyPrint(new Printer());
  }

}
