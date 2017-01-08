package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PlayerTest extends TestAssert {
  public void runTests() {

    testVariables();
    testOperations();
  }

  protected void testVariables() {

    Player p = new Player('B');
    assertTrue(p instanceof Player);
    assertTrue(Utils.equals(p.id, 'B'));
    assertTrue(Utils.equals(p.pieces.size(), 6L));
  }

  protected void testOperations() {

    Player p = new Player('B');
    VDMSeq pieces = SeqUtil.seq();
    p.setId('R');
    assertTrue(Utils.equals(p.getId(), 'R'));
    long toVar_5 = 6L;
    long byVar_5 = 1L;
    for (Long i = 1L; byVar_5 < 0 ? i >= toVar_5 : i <= toVar_5; i += byVar_5) {
      pieces = SeqUtil.conc(Utils.copy(pieces), SeqUtil.seq(new Piece('R', i)));
    }
    p.setPieces(Utils.copy(pieces));
    assertTrue(Utils.equals(p.getPieces(), pieces));
  }

  public PlayerTest() {}

  public String toString() {

    return "PlayerTest{}";
  }
}
