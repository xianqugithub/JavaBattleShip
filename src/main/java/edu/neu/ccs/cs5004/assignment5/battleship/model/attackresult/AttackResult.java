package edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult;

public interface AttackResult {

  String result();

  static AttackResult createHit() {
    return new Hit();
  }

  static AttackResult createMiss() {
    return new Miss();
  }

  static AttackResult createSunk() {
    return new Sunk();
  }

}
