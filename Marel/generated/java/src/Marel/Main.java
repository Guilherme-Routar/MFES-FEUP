package Marel;

import org.overture.codegen.runtime.VDMSeq;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Game g = new Game();
		Player jogadorAtual = g.player1;

		Scanner scan = new Scanner(System.in);
		String str_input = "";
		do{
			draw(g.board.grafo_adj.Vertices);
			System.out.println("Jogador " + jogadorAtual.id);
			
			if(g.gameState.intValue() == 1){
				System.out.println("Insira um local a jogar ou E para sair:");
				str_input = scan.nextLine();
				if(str_input.equals("e")||str_input.equals("E"))
					return;
				g.putPiece(jogadorAtual, Integer.parseInt(str_input), 1);
			}
			else if (g.gameState.intValue() == 2){
				System.out.println("Mover a peca de (E para sair):");
				str_input = scan.nextLine();
				if(str_input.equals("e")||str_input.equals("E"))
					return;
				int de = Integer.parseInt(str_input);
				System.out.println("Para (E para sair):");
				str_input = scan.nextLine();
				if(str_input.equals("e")||str_input.equals("E"))
					return;
				int para = Integer.parseInt(str_input);
				g.movePeca(jogadorAtual, para, de);
			}else{
				scan.close();
				return;
			}
				
			jogadorAtual = (jogadorAtual==g.player1) ? g.player2 : g.player1;
			g.updateGameState();
			if(g.verificaMill(Integer.parseInt(str_input))){
				System.out.println("Indique uma peca do adeversario a remover:");
				str_input = scan.nextLine();
				g.removePeca(Integer.parseInt(str_input));
			}
			System.out.println();
			
		}while(true);
	}
	
	
	
	
	
	private static void draw(VDMSeq v){
		System.out.println(getPV(v.get(13))+"------------"+getPV(v.get(14))+"------------"+getPV(v.get(15)));
		System.out.println("|            |            |");
		System.out.println("|            |            |");
		System.out.println("|     "+getPV(v.get(10))+"------"+getPV(v.get(11))+"------"+getPV(v.get(12))+"     |");
		System.out.println("|     |             |     |");
		System.out.println("|     |             |     |");
		System.out.println(getPV(v.get(6))+"-----"+getPV(v.get(7))+"             "+getPV(v.get(8))+"-----"+getPV(v.get(9)));
		System.out.println("|     |             |     |");
		System.out.println("|     |             |     |");
		System.out.println("|     "+getPV(v.get(3))+"------"+getPV(v.get(4))+"------"+getPV(v.get(5))+"     |");
		System.out.println("|            |            |");
		System.out.println("|            |            |");
		System.out.println(getPV(v.get(0))+"------------"+getPV(v.get(1))+"------------"+getPV(v.get(2)));
	}
	private static String getPV(Object o){
		Cell c = (Cell)o;
		if(c.hasPiece)
			return ""+c.piece.color;
		else
			return ""+c.id;
	}
	
}
