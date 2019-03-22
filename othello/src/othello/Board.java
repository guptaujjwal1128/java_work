package othello;

public class Board {
	Player p1;
	Player p2;
	int[][] board;
	int size = 8;
	int count = 4;// NO OF PLACES FILLED
	int Bcount = 2;// NO OF BLACK PLACES FILLED
	int Wcount = 2;// NO OF WHITE PLACES FILLED
	int p1Symbol, p2Symbol;
	public final static int PLAYER_1_WIN = 1;
	public final static int PLAYER_2_WIN = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;

	public Board(int p1Symbol, int p2Symbol) {
		board = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = 0;
			}
		}
		board[3][3] = p1.BLACK;
		board[4][4] = p1.BLACK;
		board[3][4] = p1.WHITE;
		board[4][3] = p1.WHITE;
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}

	public void printBoard() {
		System.out.println("   0  1  2  3  4  5  6  7 ");
		System.out.println("---------------------------");
		for (int i = 0; i < size; i++) {
			System.out.print(i + "|");
			for (int j = 0; j < size; j++) {
				System.out.print("|" + board[i][j] + "|");
			}
			System.out.println("|");
		}
		System.out.println("---------------------------");
	}

	public void printInstructions() {
		System.out.println("        OTHELLO       ");
		System.out.println("1) 1 IS FOR BLACK");
		System.out.println("2) 2 IS FOR WHITE");
		System.out.println("3) ENTER THE X AND Y CO ORDINATES TO PLAY");
	}

	// THIS TELLS WHETHER THE MOVE MADE IS POSSIBLE OR NOT ANS
	// ALSO MADE THE REQUIRED CHNAGES IN THE GAME
	public boolean move(int symbol, int x, int y) {
		if (x < 0 || y < 0 || x >= 8 || y >= 8 || board[x][y] != 0) {
			System.out.println("INVALID MOVE !!!!!!");
			return false;
		}
		int[] xDir = { 0, 0, 1, -1, 1, -1, -1, 1 };
		int[] yDir = { -1, 1, 0, 0, -1, 1, -1, 1 };
		boolean flag = false;
		for (int i = 0; i < xDir.length; i++) {
			if (symbol == 1) { // BLACK
				int a = 1;
				if ((x + (a * xDir[i])) >= 0 && (x + (a * xDir[i])) < 8 && (y + (a * yDir[i])) >= 0
						&& (y + (a * yDir[i])) < 8) {
					while (board[x + (a * xDir[i])][y + (a * yDir[i])] == 2) {
						a++;
					}
					if ((x + (a * xDir[i])) >= 0 && (x + (a * xDir[i])) < 8 && (y + (a * yDir[i])) >= 0
							&& (y + (a * yDir[i])) < 8) {
						if (board[x + (a * xDir[i])][y + (a * yDir[i])] == 1 && a > 1) {
							for (int j = 1; j < a; j++) {
								board[x + (j * xDir[i])][y + (j * yDir[i])] = 1;
								Bcount++;
								Wcount--;
							}
							board[x][y] = 1;
							Bcount++;
							flag = true;
						}
					}
				}
				// else flag = false;
			} else { // WHITE
				int a = 1;
				if ((x + (a * xDir[i])) >= 0 && (x + (a * xDir[i])) < 8 && (y + (a * yDir[i])) >= 0
						&& (y + (a * yDir[i])) < 8) {
					while (board[x + (a * xDir[i])][y + (a * yDir[i])] == 1) {
						a++;
					}
					if ((x + (a * xDir[i])) >= 0 && (x + (a * xDir[i])) < 8 && (y + (a * yDir[i])) >= 0
							&& (y + (a * yDir[i])) < 8) {
						if (board[x + (a * xDir[i])][y + (a * yDir[i])] == 2 && a > 1) {
							for (int j = 1; j < a; j++) {
								board[x + (j * xDir[i])][y + (j * yDir[i])] = 2;
								Wcount++;
								Bcount--;
							}
							board[x][y] = 2;
							Wcount++;
							flag = true;
						}
					}
				}

				// else flag = false;
			}
		}
		return flag;
	}
}
