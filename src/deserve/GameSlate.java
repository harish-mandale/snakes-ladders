package deserve;

import java.util.List;
import java.util.Queue;

public class GameSlate {
	protected List<ISquare> squares;
	protected int size;
	protected Queue<Player> players;
	protected Player winner;
	public void play(Dice die) {
		System.out.println("Initial state: " + this);
		while (this.notOver()) {
			int roll = die.roll();
			System.out.println(this.currentPlayer()
			+ " rolls " + roll + ": " + this);
			this.movePlayer(roll);
		}
		System.out.println("Final state: " + this);
		System.out.println(this.winner() + " wins!");
	}
	
	public boolean notOver() {
		return winner == null;
	}
	
	public Player currentPlayer() {
		return players.peek();
	}
	
	public void movePlayer(int roll) {
		Player currentPlayer = players.remove(); // from front of queue
		currentPlayer.moveForward(roll);
		players.add(currentPlayer); // to back of the queue
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
	}
	
	public Player winner() {
		return winner;
	}
}
