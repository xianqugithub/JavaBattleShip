package edu.neu.ccs.cs5004.assignment5.battleship.view.consoleprinter;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.OpenSeaWaterCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.map.Map;
import edu.neu.ccs.cs5004.assignment5.battleship.model.player.Player;
import edu.neu.ccs.cs5004.assignment5.battleship.model.ship.Ship;

import static org.junit.Assert.*;

public class PrinterTest {
  Printer printer;
  Cell example1= Cell.createGapWaterCell();
  Cell example2= Cell.createOpenSeaWaterCell();
  Cell example3= Cell.createEnemyShipCell();
  Cell example4= Cell.createSpecificShipCell(Ship.createSubmarine());
  Cell example6 = Cell.createSpecificShipCell(Ship.createBattleShip());
  Cell example7 = Cell.createSpecificShipCell(Ship.createCruiser());
  Cell example8 = Cell.createSpecificShipCell(Ship.createDestroyer());

  Map example5 = Map.createMap();
  @Before
  public void setUp() throws Exception {
    printer= new Printer();
  }

  @Test
  public void toConsole() {
    printer.toConsole((GapWaterCell)example1);
    printer.toConsole((GapWaterCell)example1.attackCell());
    printer.toConsole((EnemyShipCell) example3);
    printer.toConsole((EnemyShipCell) example3.attackCell());
    printer.toConsole((OpenSeaWaterCell) example2);
    printer.toConsole((OpenSeaWaterCell) example2.attackCell());
    printer.toConsole((SpecificShipCell) example4);
    printer.toConsole((SpecificShipCell) example6);
    printer.toConsole((SpecificShipCell) example7);
    printer.toConsole((SpecificShipCell) example8);
    printer.toConsole(example5);
  }
}