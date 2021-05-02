package deserve;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class SnakeNLadderBoard {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	final static int WIN_POSITION = 100;
	final static int TOTAL_TURNS = 10;
	private final Map<Integer, Integer> snakes = new HashMap<>();
	private final Map<Integer, Integer> ladders = new HashMap<>();
	private int actualTurn = 0;
	private int playerPosition = 0;

	public void addSnakes(final Map<Integer, Integer> snakes){
		this.snakes.putAll(snakes);
	}

	public void addLadders(final Map<Integer, Integer> ladders){
		this.ladders.putAll(ladders);
	}
	public boolean ifExceedingWinPosition(final int playerPosition, final int diceValue){
		return playerPosition + diceValue > WIN_POSITION;
	}

	public int nextMove(final int diceValue) throws IllegalArgumentException{
		if(diceValue == -1)
		   throw new IllegalArgumentException();
		if(actualTurn <= TOTAL_TURNS) {
			if(ifExceedingWinPosition(playerPosition, diceValue)){
				return playerPosition;
			}
			updatePlayerPosition(diceValue);
			playerPosition = snakeNLadderCheck();
			if(isWinner(playerPosition)) {
				LOGGER.info("Player won the Snakes-Ladders game:"+ playerPosition);
				return playerPosition;
			}
			incrementActualTurn();
		}else{
			System.out.println("All turns exausted");
			LOGGER.info("All turns exausted");
		}
		return playerPosition;
	}

	public int snakeNLadderCheck(){
		playerPosition = snakes.getOrDefault(playerPosition, playerPosition);
		playerPosition = ladders.getOrDefault(playerPosition, playerPosition);
		return playerPosition;
	}
	
	public void incrementActualTurn() {
		actualTurn++;
	}
	
	public void updatePlayerPosition(int value) {
		playerPosition = playerPosition + value;
	}
	
	public int rollEvenNumbersDice(){
		Random rand = new Random();
		int randomNum = rand.nextInt(7);
		int num =  randomNum % 2 == 0 ? randomNum : rollEvenNumbersDice();
		return num;
	}
	
	public boolean isWinner(int playerPosition) {
		return playerPosition == WIN_POSITION;
	}
}
