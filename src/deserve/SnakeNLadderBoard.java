package deserve;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeNLadderBoard {

	final static int WIN = 100;
	final static int TURNS = 100;
	public static void main(String args[])
	{
		Map<Integer, Integer> snakes = new HashMap<>();
		snakes.put(14,7);
		Map<Integer, Integer> ladders = new HashMap<>();
		ladders.put(9,25);
		ladders.put(37,88);
		int player = 0;
		int turn = 1;
		while(turn <= TURNS)
		{
			int diceValue = rollDice();
			player = player + diceValue;
			player = snakeNLadderCheck(player, snakes);
			player = snakeNLadderCheck(player, ladders);
			if(isWinner(player))
			{
				System.out.println("Player won the Snakes-Ladders game:"+ player);
				break;
			}
			turn++;
		}
		
	}
	
	public static int snakeNLadderCheck(int player, Map<Integer, Integer> map)
	{
		for(Map.Entry<Integer, Integer> item: map.entrySet())
		{
			if(player == item.getKey()) {
				player = item.getValue();
			    break;
			}
		}
		return player;
	}
	
	public static int rollDice()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt(7);
		int num =  randomNum % 2 == 0 ? randomNum : rollDice();
		return num;
	}
	
	public static boolean isWinner(int player)
	{
		return player >= WIN; 
	}
}
