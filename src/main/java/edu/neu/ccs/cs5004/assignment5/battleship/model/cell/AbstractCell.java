package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import java.util.Objects;

abstract class AbstractCell implements Cell {

  private Boolean isHit;

  AbstractCell(Boolean isHit) {
    this.isHit = isHit;
  }

  public Boolean getIsHit() {
    return this.isHit;
  }

  @Override
  public Cell updateTheShip() {
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractCell that = (AbstractCell) obj;

    return Objects.equals(isHit, that.isHit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isHit);
  }

}
