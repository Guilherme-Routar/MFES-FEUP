package Marel;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GameTest extends TestAssert {
  public void runTests() {

    testVariables();
    testColocaPeca();
    testRemovePeca();
    testMovePeca();
    testAtualizaFase();
    testMill();
  }

  protected void testVariables() {

    Game game = new Game();
    assertTrue(game instanceof Game);
    assertTrue(Utils.equals(game.player1.id, 'B'));
    assertTrue(Utils.equals(game.player2.id, 'R'));
    assertTrue(!(Utils.equals(game.player1, game.player2)));
    assertTrue(Utils.equals(game.gameState, 1L));
    assertFalse(Utils.equals(game.board, null));
  }

  protected void testColocaPeca() {

    Game game = new Game();
    Number idCelulaDestino = 1L;
    Number idPeca = 1L;
    assertTrue(Utils.equals(((Piece) Utils.get(game.player1.pieces, idPeca)).pieceState, 0L));
    assertTrue(
        Utils.equals(((Piece) Utils.get(game.player1.pieces, idPeca)).color, game.player1.id));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, false));
    assertTrue(Utils.equals(game.gameState, 1L));
    game.putPiece(game.player1, idCelulaDestino, idPeca);
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece.id, idPeca));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece.color,
            game.player1.id));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, true));
  }

  protected void testRemovePeca() {

    Game game = new Game();
    Number idCelulaDestino = 1L;
    Number idPeca = 1L;
    game.putPiece(game.player1, idCelulaDestino, idPeca);
    assertTrue(Utils.equals(((Piece) Utils.get(game.player1.pieces, idPeca)).pieceState, 1L));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, true));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece.pieceState,
            1L));
    assertTrue(
        SetUtil.inSet(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece,
            SeqUtil.elems(game.player1.pieces)));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece.id,
            ((Piece) Utils.get(game.player1.pieces, idPeca)).id));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, true));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece.id,
            ((Piece) Utils.get(game.player1.pieces, idPeca)).id));
    game.removePeca(idCelulaDestino);
    assertTrue(Utils.equals(((Piece) Utils.get(game.player1.pieces, idPeca)).pieceState, -1L));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, false));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece, null));
  }

  protected void testMovePeca() {

    Game game = new Game();
    Piece peca = ((Piece) Utils.get(game.player1.pieces, 1L));
    Number idCelulaOrigem = 1L;
    Number idCelulaDestino = 2L;
    ((Piece) Utils.get(game.player1.pieces, 1L)).pieceState = 0L;
    ((Piece) Utils.get(game.player1.pieces, 2L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 3L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 4L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 5L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 6L)).pieceState = 1L;
    game.putPiece(game.player1, idCelulaOrigem, peca.id);
    ((Piece) Utils.get(game.player1.pieces, 1L)).pieceState = 1L;
    game.gameState = 2L;
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaOrigem)).hasPiece, true));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, false));
    assertTrue(
        !(Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaOrigem)).piece, null)));
    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaOrigem)).piece.pieceState,
            1L));
    assertTrue(
        SetUtil.inSet(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaOrigem)).piece.id,
            SeqUtil.inds(game.player1.pieces)));
    game.movePeca(game.player1, idCelulaDestino, idCelulaOrigem);
    Boolean andResult_15 = false;

    if (Utils.equals(
        ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaOrigem)).hasPiece, false)) {
      if (Utils.equals(
          ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaOrigem)).piece, null)) {
        andResult_15 = true;
      }
    }

    assertTrue(andResult_15);

    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).hasPiece, true));
    VDMSet setCompResult_2 = SetUtil.set();
    VDMSet set_3 = SeqUtil.elems(game.player1.pieces);
    for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext(); ) {
      Piece p = ((Piece) iterator_3.next());
      if (Utils.equals(p.pieceState, 0L)) {
        setCompResult_2.add(p);
      }
    }
    assertTrue(Utils.equals(setCompResult_2.size(), 0L));

    assertTrue(
        Utils.equals(
            ((Cell) Utils.get(game.board.grafo_adj.Vertices, idCelulaDestino)).piece.pieceState,
            1L));
  }

  protected void testAtualizaFase() {

    Game game = new Game();
    ((Piece) Utils.get(game.player1.pieces, 1L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 2L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 3L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 4L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 5L)).pieceState = 1L;
    ((Piece) Utils.get(game.player1.pieces, 6L)).pieceState = 1L;
    game.updateGameState();
    assertTrue(Utils.equals(game.gameState, 1L));
    ((Piece) Utils.get(game.player2.pieces, 1L)).pieceState = 1L;
    ((Piece) Utils.get(game.player2.pieces, 2L)).pieceState = 1L;
    ((Piece) Utils.get(game.player2.pieces, 3L)).pieceState = 1L;
    ((Piece) Utils.get(game.player2.pieces, 4L)).pieceState = 1L;
    ((Piece) Utils.get(game.player2.pieces, 5L)).pieceState = 1L;
    ((Piece) Utils.get(game.player2.pieces, 6L)).pieceState = 1L;
    game.updateGameState();
    assertTrue(Utils.equals(game.gameState, 2L));
  }

  protected void testMill() {

    Game game = new Game();
    Number idCelulaDestino = 1L;
    Number idPeca = 1L;
    Number idPeca1 = 2L;
    Number idPeca2 = 3L;
    game.putPiece(game.player1, 1L, idPeca);
    assertFalse(game.verificaMill(idCelulaDestino));
    game.putPiece(game.player1, 2L, idPeca1);
    game.putPiece(game.player1, 3L, idPeca2);
    assertTrue(game.verificaMill(idCelulaDestino));
  }

  public GameTest() {}

  public String toString() {

    return "GameTest{}";
  }
}
