package tictactoe;

public class GameBoard {
	private char[][] board;  //2D ARRAY AS GAME BOARD
	private int size = 3;   // 3 x 3 boxes
	private int count;      //number of boxes filled or turns played 
	private char p1Symbol,p2Symbol;
	
	//constructor
	public GameBoard(char p1Symbol,char p2Symbol) {
		board = new char[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				board[i][j] = '\0';
			}
		}
		count = 0;
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}

	//print game board
	public void CreateGameBoard() {
		System.out.println(" 0   1   2");
		System.out.println("____________");
		System.out.println();
		for(int i=0;i<size;i++) {
			System.out.print(i+"|");
			for(int j=0;j<size;j++) {
				System.out.print("|"+board[i][j]+"|");
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("_____________");
	}
	
	//print instructions
	public void printInstructions() {
		System.out.println("1) Enter the co ordinates to play");
		System.out.println("2) The player1 will start the game");
	}
	
	//return status of the game
	public int StatusOfGame(char symbol,int x,int y) {
		//INVALID CASE
		if(board[x][y]!='\0'||x<0||y<0||x>=size||y>=size) {
			return 5;
		}
		board[x][y] = symbol;
		count++;
		//check row
			if(board[x][0]==board[x][1]&&board[x][0]==board[x][2]) {
				if(symbol==p1Symbol) return 1; 		//PLAYER 1 WINS
				else return 2;						//PLAYER 2 WINS
			}
		//check column	
			if(board[0][y]==board[1][y]&&board[0][y]==board[2][y]) {
				if(symbol==p1Symbol) return 1; 		//PLAYER 1 WINS
				else return 2;						//PLAYER 2 WINS
			}
		//check diagonal 1	
			if(board[0][0]!='\0'&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]) {
				if(symbol==p1Symbol) return 1; 		//PLAYER 1 WINS
				else return 2;						//PLAYER 2 WINS
			}
		//check diagonal 2	
			if(board[0][size-1]!='\0'&&board[0][2]==board[1][1]&&board[0][2]==board[2][0]) {
				if(symbol==p1Symbol) return 1; 		//PLAYER 1 WINS
				else return 2;						//PLAYER 2 WINS
			}
			if(count==(size*size)) return 3;
			return 4;
	}

}
