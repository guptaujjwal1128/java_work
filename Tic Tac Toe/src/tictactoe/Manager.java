package tictactoe;

import java.util.Scanner;

public class Manager {
	Players p1; // FIRST PLAYER
	Players p2; // SECOND PLAYER
	GameBoard board; // GAME BOARD
	private boolean p1Turn = false; // PLAYER 1 TURN STATUS IF TRUE
									// ELSE PLAYER 2 TURN

	public final static int PLAYER_1_TURN = 1;
	public final static int PLAYER_2_TURN = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;

	// takes the name and symbol from player
	public Players TakeInputPlayer(int num) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter the name of player "+num);
		String name = sc.nextLine();
		System.out.println("please enter X or O as symbol of player "+num);
		char symbol = sc.next().charAt(0);
		Players p = new Players(name, symbol);
		return p;
	}

	// conduct game
	public void conduct() {
		p1 = TakeInputPlayer(1);
		p2 = TakeInputPlayer(2);
		while(p1.getsymbol()==p2.getsymbol()) {
			System.out.println("SAME SYMBOL.PLEASE SELECT ANOTHER SYMBOL");
			Scanner sc = new Scanner(System.in);
			char symbol = sc.next().charAt(0);
			p2.setSymbol(symbol);
		}
		board = new GameBoard(p1.getsymbol(),p2.getsymbol());
		board.CreateGameBoard();
		board.printInstructions();
		p1Turn = true;
		Scanner sc = new Scanner(System.in);
		int status = INCOMPLETE;
		while (status == INCOMPLETE || status == INVALID) {
			if (p1Turn) {
				System.out.println("PLAYER 1 TURN!!!");
				System.out.println("Enter x co ordinate");
				int x = sc.nextInt();
				System.out.println("Enter y co ordinate");
				int y = sc.nextInt();
				status = board.StatusOfGame(p1.getsymbol(),x, y);
				if (status == INVALID) {
				System.out.println("INVALID MOVE");
				}
				else {
					p1Turn = false;
					board.CreateGameBoard();
				} 
			}
			else {
				System.out.println("PLAYER 2 TURN!!!");
				System.out.println("Enter x co ordinate");
				int x = sc.nextInt();
				System.out.println("Enter y co ordinate");
				int y = sc.nextInt();
				status = board.StatusOfGame(p2.getsymbol(),x, y);
				if (status == INVALID) {
				System.out.println("INVALID MOVE");	
				}
				else {
					p1Turn = true;
					board.CreateGameBoard();
				}
			}
		}
		if(status==PLAYER_1_TURN) System.out.println("PLAYER 1 WINS!!!!");
		else if(status==PLAYER_2_TURN) System.out.println("PLAYER 2 WINS!!!!");
		else System.out.println("DRAW");
	}
}
