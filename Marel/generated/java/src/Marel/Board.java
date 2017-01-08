package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Board {
  public Grafo grafo_adj = null;

  public void cg_init_Board_1() {

    grafo_adj = new Grafo();
    buildPossibleMills();
    return;
  }

  public Board() {

    cg_init_Board_1();
  }

  public void buildPossibleMills() {

    VDMSeq mills =
        SeqUtil.seq(
            SetUtil.set(1L, 2L, 3L),
            SetUtil.set(4L, 5L, 6L),
            SetUtil.set(11L, 12L, 13L),
            SetUtil.set(14L, 15L, 16L),
            SetUtil.set(1L, 7L, 14L),
            SetUtil.set(3L, 10L, 16L),
            SetUtil.set(4L, 8L, 11L),
            SetUtil.set(6L, 9L, 13L));
    for (Iterator iterator_4 = SeqUtil.elems(grafo_adj.Vertices).iterator();
        iterator_4.hasNext();
        ) {
      Cell c = (Cell) iterator_4.next();
      VDMSeq mill = SeqUtil.seq();
      for (Iterator iterator_5 = SeqUtil.elems(Utils.copy(mills)).iterator();
          iterator_5.hasNext();
          ) {
        VDMSet s = (VDMSet) iterator_5.next();
        if (SetUtil.inSet(c.id, s)) {
          VDMSeq seqCompResult_1 = SeqUtil.seq();
          VDMSet set_1 = Utils.copy(s);
          for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext(); ) {
            Number n = ((Number) iterator_1.next());
            if (!(Utils.equals(n, c.id))) {
              seqCompResult_1.add(n);
            }
          }
          mill = SeqUtil.conc(Utils.copy(mill), Utils.copy(seqCompResult_1));
        }
      }
      c.setMills(Utils.copy(mill));
    }
  }

  public void putPiece(final Number idCell, final Piece piece) {

    Cell c = ((Cell) Utils.get(grafo_adj.Vertices, idCell));
    c.hasPiece = true;
    c.piece = piece;
    c.piece.pieceState = 1L;
  }

  public String toString() {

    return "Board{" + "grafo_adj := " + Utils.toString(grafo_adj) + "}";
  }
}
