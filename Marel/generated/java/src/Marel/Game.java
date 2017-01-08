package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Game {
  public Board board = null;
  public Player player1;
  public Player player2;
  public Number gameState = 1L;

  public void cg_init_Game_1() {

    board = new Board();
    player1 = new Player('B');
    player2 = new Player('R');
    updateGameState();
  }

  public Game() {

    cg_init_Game_1();
  }

  public void updateGameState() {

    VDMSet setCompResult_1 = SetUtil.set();
    VDMSet set_2 = SeqUtil.elems(SeqUtil.conc(player1.pieces, player2.pieces));
    for (Iterator iterator_2 = set_2.iterator(); iterator_2.hasNext(); ) {
      Piece p = ((Piece) iterator_2.next());
      if (Utils.equals(p.pieceState, 0L)) {
        setCompResult_1.add(p);
      }
    }
    if (setCompResult_1.size() > 0L) {
      gameState = 1L;
    } else {
      gameState = 2L;
    }
  }

  public void putPiece(final Player player, final Number idDestinyCell, final Number idPiece) {

    board.putPiece(idDestinyCell, ((Piece) Utils.get(player.pieces, idPiece)));
  }

  public void removePeca(final Number idCelula) {

    Cell celula = ((Cell) Utils.get(board.grafo_adj.Vertices, idCelula));
    celula.hasPiece = false;
    celula.piece.pieceState = -1L;
    celula.piece = null;
  }

  public void movePeca(
      final Player jogador, final Number idCelulaDestino, final Number idCelulaOrigem) {

    Number idPeca = ((Cell) Utils.get(board.grafo_adj.Vertices, idCelulaOrigem)).piece.id;
    Piece peca = ((Piece) Utils.get(jogador.pieces, idPeca));
    Cell celOri = ((Cell) Utils.get(board.grafo_adj.Vertices, idCelulaOrigem));
    Cell celDest = ((Cell) Utils.get(board.grafo_adj.Vertices, idCelulaDestino));
    celOri.piece = null;
    celOri.hasPiece = false;
    celDest.piece = ((Piece) Utils.get(jogador.pieces, idPeca));
    celDest.hasPiece = true;
    celDest.piece = peca;
    celDest.piece.pieceState = 1L;
  }

  public Boolean verificaMill(final Number idx) {

    Cell cel = ((Cell) Utils.get(board.grafo_adj.Vertices, idx));
    VDMSeq mills = cel.cellMills;
    Character cor = ((Cell) Utils.get(board.grafo_adj.Vertices, idx)).piece.color;
    Number n = mills.size();
    long toVar_1 = n.longValue();
    long byVar_1 = 1L;
    for (Long i = 1L; byVar_1 < 0 ? i >= toVar_1 : i <= toVar_1; i += byVar_1) {
      Boolean andResult_12 = false;

      if (Utils.equals(
          ((Cell) Utils.get(board.grafo_adj.Vertices, ((Number) Utils.get(mills, i)))).hasPiece,
          true)) {
        Boolean andResult_13 = false;

        if (Utils.equals(
            ((Cell)
                    Utils.get(
                        board.grafo_adj.Vertices, ((Number) Utils.get(mills, i.longValue() + 1L))))
                .hasPiece,
            true)) {
          Boolean andResult_14 = false;

          if (Utils.equals(
              ((Cell) Utils.get(board.grafo_adj.Vertices, ((Number) Utils.get(mills, i))))
                  .piece
                  .color,
              cor)) {
            if (Utils.equals(
                ((Cell)
                        Utils.get(
                            board.grafo_adj.Vertices,
                            ((Number) Utils.get(mills, i.longValue() + 1L))))
                    .piece
                    .color,
                cor)) {
              andResult_14 = true;
            }
          }

          if (andResult_14) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          andResult_12 = true;
        }
      }

      if (andResult_12) {
        return true;
      }
    }
    return false;
  }

  public String toString() {

    return "Game{"
        + "board := "
        + Utils.toString(board)
        + ", player1 := "
        + Utils.toString(player1)
        + ", player2 := "
        + Utils.toString(player2)
        + ", gameState := "
        + Utils.toString(gameState)
        + "}";
  }
}
