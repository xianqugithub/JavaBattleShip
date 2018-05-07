package edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult;

class Sunk implements AttackResult {
  @Override
  public String result() {
    return "Sunk";
  }

  @Override
  public int hashCode() {
    return 29;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    return true;
  }
}
