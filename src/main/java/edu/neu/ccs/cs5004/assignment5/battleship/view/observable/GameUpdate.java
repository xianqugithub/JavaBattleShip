package edu.neu.ccs.cs5004.assignment5.battleship.view.observable;

import edu.neu.ccs.cs5004.assignment5.battleship.model.game.Game;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.view.observer.Observer;

class GameUpdate extends AbstractObservable{

  private Game game;

  GameUpdate(Game game) {
    super();
    this.game = game;
  }

  @Override
  public void subscribeViewers(Observer obs) {
    observers.add(obs);
    obs.update(game);
  }


  @Override
  public void notifyObservers() {
    for (Observer obs:observers) {
      obs.update(game);
    }

  }

  public void updateGame(Game newGame) {
    this.game = newGame;
    notifyObservers();
  }

  @Override
  public void updateMap(Map newMap) {
  }


}
