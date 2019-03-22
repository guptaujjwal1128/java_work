package othello;

import java.util.Scanner;

public class Manager {
	Player p1;
	Player p2;
	Board board;

	// TAKE INPUT
	public Player takeInputPlayer(int num) {
		System.out.println("Enter the name of player " + num);
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter the symbol of player " + num);
		int symbol = sc.nextInt();
		Player p = new Player(name, symbol);
		while (!p.setSymbol(symbol)) {
			System.out.println("Invalid Symbol!!Try again..");
			symbol = sc.nextInt();
		}
		return p;
	}

	public void startGame() {
		p1 = takeInputPlayer(1);
		p2 = takeInputPlayer(2);
		Scanner sc = new Scanner(System.in);
		while (p1.getSymbol() == p2.getSymbol()) {
			System.out.println("SAME SYMBOL,TRY AGAIN");
			int symbol = sc.nextInt();
			p2.setSymbol(symbol);
			while (!p2.setSymbol(symbol)) {
				System.out.println("INVALID SYMBOL,TRY AGAIN");
				symbol = sc.nextInt();
				p2.setSymbol(symbol);
			}
		}
		// CREATING THE BOARD
		board = new Board(p1.getSymbol(), p2.getSymbol());
		board.printBoard();
		board.printInstructions();
		// CONDUCTING THE GAME
		boolean p1Turn = true;
		while (true) {
			if (p1Turn) {
				System.out.println("Player 1 turn!!!!");
				System.out.println("Enter x co ordinate");
				int x = sc.nextInt();
				System.out.println("Enter y co ordinate");
				int y = sc.nextInt();
				boolean flag = board.move(p1.getSymbol(), y, x);
				if (flag) {
					board.printBoard();
					System.out.println(board.Bcount);
					System.out.println(board.Wcount);
					p1Turn = false;
				} else
					System.out.println("INVALID MOVE!!!!");
			} else {
				System.out.println("Player 2 turn!!!!");
				System.out.println("Enter x co ordinate");
				int x = sc.nextInt();
				System.out.println("Enter y co ordinate");
				int y = sc.nextInt();
				boolean flag = board.move(p2.getSymbol(), y, x);
				if (flag) {
					board.printBoard();
					System.out.println(board.Bcount);
					System.out.println(board.Wcount);
					p1Turn = true;
				} else
					System.out.println("INVALLID MOVE!!!");
			}
			if (board.count >= 64)
				break;
		}

		if (board.Bcount > board.Wcount) {
			if (p1.getSymbol() == p1.BLACK)
				System.out.println("Player 1 wins");
			else
				System.out.println("Player 2 wins");
		} else if (board.Bcount < board.Wcount) {
			if (p1.getSymbol() == p1.WHITE)
				System.out.println("Player 1 wins");
			else
				System.out.println("Player 2 wins");
		} else {
			System.out.println("DRAW!!!!");
		}
	}
}
