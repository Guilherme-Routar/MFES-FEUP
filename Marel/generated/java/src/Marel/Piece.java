package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Piece {
  public Number id;
  public Character color;
  public Number pieceState = 0L;

  public void cg_init_Piece_1(final Character c, final Number i) {

    color = c;
    id = i;
    pieceState = 0L;
  }

  public Piece(final Character c, final Number i) {

    cg_init_Piece_1(c, i);
  }

  public Character getColor() {

    return color;
  }

  public void setColor(final Character newColor) {

    color = newColor;
  }

  public Number getId() {

    return id;
  }

  public void setId(final Number newId) {

    id = newId;
  }

  public Piece() {}

  public String toString() {

    return "Piece{"
        + "id := "
        + Utils.toString(id)
        + ", color := "
        + Utils.toString(color)
        + ", pieceState := "
        + Utils.toString(pieceState)
        + "}";
  }
}
