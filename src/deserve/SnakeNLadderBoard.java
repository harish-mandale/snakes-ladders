package deserve;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeNLadderBoard {
	protected int size;
	protected List<ISquare> squares = new ArrayList<>();
	protected Player winner;
	protected Player player;
	private int TOTAL_TURNS = 10;
	private int actualTurn = 1;
	public SnakeNLadderBoard(int size) {
		this.size = size;
	}
	
	public void setSquareToLadder(int position, int moves) {
		
	}

	public ISquare findSquare(int position, int move) {
		return this.getSquare(target);
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
		if (player.wins()) {
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
	
	public boolean isWinner(int playerPosition) {
		return playerPosition == WIN_POSITION;
	}
}
