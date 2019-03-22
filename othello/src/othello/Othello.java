package othello;

public class Othello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Player p1 = new Player("ujjwal",1);
		Player p2 = new Player("demon",2);
		Board b = new Board(1,2);
		Manager m = new Manager();
		b.printBoard();
		boolean status  = b.move(1, 3,5 );
		if(status==false) {
			System.out.println("move again");
		} 
		b.printBoard();*/
		Manager m = new Manager();
		m.startGame();		
	}
}
