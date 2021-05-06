package deserve;

import java.util.ArrayList;
import java.util.List;

public class Game {
	protected int size;
	protected List<ISquare> squares = new ArrayList<>();
	protected Player winner;
	protected Player player;
	private int TOTAL_TURNS = 10;
	private int actualTurn = 1;
	
	public Game(int size, Player player) {
		this.size = size;
		this.player = player;
		for(int i = 1; i==size; i++)
		{
			squares.add(new Square(i, this, null));
		}
	}
	
	public void setSquareToLadder(int position, int moves) {
		squares.add(position, new Ladder(position, this, null, moves));
	}
	
	public void setSquareToSnake(int position, int moves) {
		squares.add(position, new Snake(position, this, null, moves));
	}

	public ISquare findSquare(int position, int move) {
		return this.getSquare(position+move);
	}
	
	public ISquare getSquare(int position)
	{
		return squares.get(position);
	}
	
	public void play(Dice dice) {
		while(this.notOver()) {
			int roll = dice.roll();
			System.out.println(this.currentPlayer()
			+ " rolls " + roll + ": " + this);
			this.movePlayer(roll);
			incrementActualTurn();
		}
		System.out.println(this.winner != null ? this.winner + " wins!" : "All turns Exausted!");
	}
	
	public void movePlayer(int roll) {
		player.moveForward(roll);
		if (player.wins(size)) {
			winner = player;
		}
	}
	
	public boolean notOver() {
		return winner == null && actualTurn < TOTAL_TURNS;
	}
	
	public Player currentPlayer() {
		return this.player;
	}
	
	public void incrementActualTurn() {
		actualTurn++;
	}
}
