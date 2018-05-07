package edu.neu.ccs.cs5004.assignment5.battleship.model.cell;

import edu.neu.ccs.cs5004.assignment5.battleship.model.attackresult.AttackResult;


abstract class AbstractWaterCell extends AbstractCell {
  AbstractWaterCell(Boolean isHit) {
    super(isHit);
  }

  @Override
  public Boolean hasShip() {
    return false;
  }

  @Override
  public AttackResult attackResult() {
    return  AttackResult.createMiss();
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    if (super.equals(obj)) {
      return false;
    }

    AbstractWaterCell abstractWaterCell = (AbstractWaterCell) obj;
    return attackResult().equals(abstractWaterCell.attackResult());
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (attackResult() != null ? attackResult().hashCode() : 0);
    return result;
  }


}
