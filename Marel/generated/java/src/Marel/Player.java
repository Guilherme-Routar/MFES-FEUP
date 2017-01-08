package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Player {
  public Character id;
  public VDMSeq pieces = SeqUtil.seq();

  public void cg_init_Player_1(final Character t) {

    id = t;
    long toVar_4 = 6L;
    long byVar_4 = 1L;
    for (Long i = 1L; byVar_4 < 0 ? i >= toVar_4 : i <= toVar_4; i += byVar_4) {
      pieces = SeqUtil.conc(Utils.copy(pieces), SeqUtil.seq(new Piece(t, i)));
    }
    return;
  }

  public Player(final Character t) {

    cg_init_Player_1(t);
  }

  public Character getId() {

    return id;
  }

  public void setId(final Character newId) {

    id = newId;
  }

  public VDMSeq getPieces() {

    return Utils.copy(pieces);
  }

  public void setPieces(final VDMSeq newSet) {

    pieces = Utils.copy(newSet);
  }

  public Player() {}

  public String toString() {

    return "Player{"
        + "id := "
        + Utils.toString(id)
        + ", pieces := "
        + Utils.toString(pieces)
        + "}";
  }
}
