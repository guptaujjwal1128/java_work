package othello;

public class Player {
	private String name; // NAME OF PLAYER
	private int symbol; // SYMBOL OF PLAYER
	public final static int BLACK = 1; // 1 FOR BLACK
	public final static int WHITE = 2; // 2 FOR WHITE

	// CONSTRUCTOR
	public Player(String name, int symbol) {
		this.setName(name);
		this.setSymbol(symbol);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSymbol() {
		return symbol;
	}

	public boolean setSymbol(int symbol) {
		if (symbol == 1 || symbol == 2) {
			this.symbol = symbol;
			return true;
		} else
			return false;
	}
}
