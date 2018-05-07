package edu.neu.ccs.cs5004.assignment5.battleship.view.observable;

import edu.neu.ccs.cs5004.assignment5.battleship.view.observer.Observer;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractObservable implements Observable{

  List<Observer> observers;

  AbstractObservable() {
    observers = new ArrayList<>();
  }

  @Override
  public void unSubscribeViewers(Observer obs) {
    observers.remove(obs);
  }
}
