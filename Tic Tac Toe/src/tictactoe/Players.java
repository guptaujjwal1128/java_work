package tictactoe;

public class Players {
	private String name;                   //name of player
	private char symbol;                   //SYMBOL
	
	//constructor
	public Players(String name,char symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public char getsymbol() {
		return symbol;
	}
}
