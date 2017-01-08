package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BoardTest extends TestAssert {
  public void runTests() {

    testVariables();
    testOperations();
  }

  protected void testVariables() {

    Board b = new Board();
    assertTrue(b instanceof Board);
  }

  protected void testOperations() {

    Board board = new Board();
    Number idCell = 1L;
    Piece piece = new Piece('B', 1L);
    board.putPiece(idCell, piece);
    assertTrue(Utils.equals(((Cell) Utils.get(board.grafo_adj.Vertices, idCell)).id, idCell));
    assertTrue(Utils.equals(((Cell) Utils.get(board.grafo_adj.Vertices, idCell)).hasPiece, true));
    assertTrue(
        Utils.equals(((Cell) Utils.get(board.grafo_adj.Vertices, idCell)).piece.id, piece.id));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(board.grafo_adj.Vertices, idCell)).piece.color, piece.color));
    assertTrue(
        Utils.equals(((Cell) Utils.get(board.grafo_adj.Vertices, idCell)).piece.pieceState, 1L));
  }

  public BoardTest() {}

  public String toString() {

    return "BoardTest{}";
  }
}
