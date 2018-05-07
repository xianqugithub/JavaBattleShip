package edu.neu.ccs.cs5004.assignment5.battleship.view.observable;

import edu.neu.ccs.cs5004.assignment5.battleship.model.game.Game;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observer.Observer;

public interface Observable {

  void subscribeViewers(Observer obs);

  void unSubscribeViewers(Observer obs);

  void notifyObservers();

  void updateGame(Game newGame);

  void updateMap(Map newMap);

  static Observable createGameUpdate(Game game) {
    return new GameUpdate(game);
  }

  static Observable createMapUpdate(Map map) {
    return new MapUpdate(map);
  }

}
