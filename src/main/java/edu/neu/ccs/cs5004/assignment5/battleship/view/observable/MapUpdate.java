package edu.neu.ccs.cs5004.assignment5.battleship.view.observable;

import edu.neu.ccs.cs5004.assignment5.battleship.model.game.Game;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observer.Observer;

public class MapUpdate extends AbstractObservable{

  private Map map;

  MapUpdate(Map map) {
    super();
    this.map = map;
  }

  @Override
  public void subscribeViewers(Observer obs) {
    observers.add(obs);
    obs.update(map);
  }

  @Override
  public void notifyObservers() {
    for (Observer obs:observers) {
      obs.update(map);
    }

  }

  @Override
  public void updateGame(Game newGame) {
  }

  @Override
  public void updateMap(Map newMap) {
    this.map = newMap;
    notifyObservers();
  }



}
