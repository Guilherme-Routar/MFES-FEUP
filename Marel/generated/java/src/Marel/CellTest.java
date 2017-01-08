package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CellTest extends TestAssert {
  public void runTests() {

    testVariables();
    testOperations();
  }

  protected void testVariables() {

    Cell c = new Cell(1L);
    assertTrue(c instanceof Cell);
    assertTrue(Utils.equals(c.id, 1L));
    assertTrue(Utils.equals(c.hasPiece, false));
    assertTrue(Utils.equals(c.piece, null));
    assertTrue(Utils.equals(c.neighbours.size(), 0L));
    assertTrue(Utils.empty(c.cellMills));
  }

  protected void testOperations() {

    Cell c = new Cell(1L);
    Piece p = new Piece('B', 1L);
    c.setHasPiece(true);
    assertTrue(Utils.equals(c.hasPiece, true));
    c.setPiece(p);
    assertTrue(c.piece instanceof Piece);
    assertTrue(Utils.equals(c.piece, p));
    c.setMills(SeqUtil.seq(1L, 2L, 3L));
    assertTrue(Utils.equals(c.cellMills, SeqUtil.seq(1L, 2L, 3L)));
    assertTrue(Utils.equals(c.getId(), 1L));
  }

  public CellTest() {}

  public String toString() {

    return "CellTest{}";
  }
}
