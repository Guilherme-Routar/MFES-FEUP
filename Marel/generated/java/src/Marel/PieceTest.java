package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PieceTest extends TestAssert {
  public void runTests() {

    testVariables();
    testOperations();
  }

  protected void testVariables() {

    Piece p = new Piece('B', 1L);
    assertTrue(p instanceof Piece);
    assertTrue(Utils.equals(p.id, 1L));
    assertTrue(Utils.equals(p.color, 'B'));
    assertTrue(Utils.equals(p.pieceState, 0L));
  }

  protected void testOperations() {

    Piece p = new Piece('B', 1L);
    p.setColor('R');
    assertTrue(Utils.equals(p.getColor(), 'R'));
    p.setId(2L);
    assertTrue(Utils.equals(p.getId(), 2L));
  }

  public PieceTest() {}

  public String toString() {

    return "PieceTest{}";
  }
}
