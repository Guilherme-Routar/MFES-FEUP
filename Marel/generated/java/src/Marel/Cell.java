package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Cell {
  public Number id;
  public Boolean hasPiece = false;
  public Piece piece = null;
  public VDMSet neighbours = SetUtil.set();
  public VDMSeq cellMills = SeqUtil.seq();

  public void cg_init_Cell_1(final Number i) {

    id = i;
    return;
  }

  public Cell(final Number i) {

    cg_init_Cell_1(i);
  }

  public Number getId() {

    return id;
  }

  public void setHasPiece(final Boolean value) {

    hasPiece = value;
  }

  public void setPiece(final Piece value) {

    piece = value;
  }

  public void setMills(final VDMSeq adjs) {

    cellMills = Utils.copy(adjs);
  }

  public Cell() {}

  public String toString() {

    return "Cell{"
        + "id := "
        + Utils.toString(id)
        + ", hasPiece := "
        + Utils.toString(hasPiece)
        + ", piece := "
        + Utils.toString(piece)
        + ", neighbours := "
        + Utils.toString(neighbours)
        + ", cellMills := "
        + Utils.toString(cellMills)
        + "}";
  }
}
