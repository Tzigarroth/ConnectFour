package cosc405.main;

import java.util.Random;
import java.util.Scanner;

import cosc405.bo.Board;

public class Main {
	
	public static void main(String[] args) {
		
		Board board = new Board();
		boolean ourTurn = true;
		boolean gameOver = false;
		Minimax minimax = new Minimax();
		
		System.out.println("Would you like to move first? Enter Y or N.");
		
		Scanner in = new Scanner(System.in);
		
		if (in.next().equals("Y")) {
			board.addPiece(in.nextInt() % 7, false);
		} else {
			Random rand = new Random();
			board.addPiece(rand.nextInt() % 7, true);
			ourTurn = false;
		}
		
		while (gameOver == false) {
			if (ourTurn) {
				int decision = minimax.minimax(board.getState(), 0, 0).getDecision();
				
				board.addPiece(decision, ourTurn);
				ourTurn = false;
				board.print();
			} else {
				System.out.println("Enter number of column you wish to put your piece in");
				board.addPiece(in.nextInt(), ourTurn);
				ourTurn = true;
				board.print();
			}
		}
		
		
	}

}
