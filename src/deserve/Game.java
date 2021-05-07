package deserve;

import java.util.HashMap;
import java.util.Map;

public class Game {
	protected int size;
	protected Map<Integer, ISquare> squares = new HashMap<>();
	protected Player winner;
	protected Player player;
	private int TOTAL_TURNS = 10;
	private int actualTurn = 1;
	
	public void setSquares(int size) {
		this.size = size;
		for(int i = 0; i<size; i++)
		{
			squares.put(i+1, new Square(i+1, this, null));
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		this.player.setInitialPosition(getSquare(1));
	}
	
	public void setSquareToLadder(int position, int moves) {
		squares.put(position, new Ladder(position, this, null, moves));
	}
	
	public void setSquareToSnake(int position, int moves) {
		squares.put(position, new Snake(position, this, null, moves));
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
