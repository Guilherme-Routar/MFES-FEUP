package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Grafo {
  public VDMSeq Vertices = SeqUtil.seq();
  public VDMSeq Arestas = SeqUtil.seq(SetUtil.set());

  public void cg_init_Grafo_1() {

    {
      long toVar_2 = 16L;
      long byVar_2 = 1L;
      for (Long i = 1L; byVar_2 < 0 ? i >= toVar_2 : i <= toVar_2; i += byVar_2) {
        Vertices = SeqUtil.conc(this.Vertices, SeqUtil.seq(new Cell(i)));
      }
    }

    Arestas =
        SeqUtil.seq(
            SetUtil.set(2L, 7L),
            SetUtil.set(1L, 3L, 5L),
            SetUtil.set(2L, 10L),
            SetUtil.set(5L, 8L),
            SetUtil.set(2L, 4L, 6L),
            SetUtil.set(5L, 9L),
            SetUtil.set(1L, 8L, 14L),
            SetUtil.set(4L, 7L, 11L),
            SetUtil.set(6L, 10L, 13L),
            SetUtil.set(3L, 9L, 16L),
            SetUtil.set(8L, 12L),
            SetUtil.set(11L, 13L, 15L),
            SetUtil.set(9L, 12L),
            SetUtil.set(7L, 15L),
            SetUtil.set(12L, 14L, 16L),
            SetUtil.set(10L, 15L));
    {
      long toVar_3 = 16L;
      long byVar_3 = 1L;
      for (Long i = 1L; byVar_3 < 0 ? i >= toVar_3 : i <= toVar_3; i += byVar_3) {
        ((Cell) Utils.get(Vertices, i)).neighbours = Utils.copy(((VDMSet) Utils.get(Arestas, i)));
      }
    }
  }

  public Grafo() {

    cg_init_Grafo_1();
  }

  public String toString() {

    return "Grafo{"
        + "Vertices := "
        + Utils.toString(Vertices)
        + ", Arestas := "
        + Utils.toString(Arestas)
        + "}";
  }
}
