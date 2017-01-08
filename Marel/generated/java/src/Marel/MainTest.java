package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MainTest {
  public void main() {

    CellTest cellTest = new CellTest();
    PieceTest pieceTest = new PieceTest();
    PlayerTest playerTest = new PlayerTest();
    GraphTest graphTest = new GraphTest();
    BoardTest boardTest = new BoardTest();
    GameTest gameTest = new GameTest();
    cellTest.runTests();
    pieceTest.runTests();
    playerTest.runTests();
    graphTest.runTests();
    boardTest.runTests();
    gameTest.runTests();
  }

  public MainTest() {}

  public String toString() {

    return "MainTest{}";
  }
}
