package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import deserve.Game;
import deserve.Player;

public class PlayerTest {

	private Game board;
	
	@Before
	public void testMain() {
		board = new Game();
		board.setSquares(100);
	}
	
	@Test
	public void testPlayerMoveForward() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       player.moveForward(1);
       assertTrue(board.getSquare(2).isOccupied());
       assertEquals(2, player.position());
	}
	
	@Test
	public void testPlayerWins() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToLadder(6, 80);
       board.setSquareToLadder(66, 20);
       board.setSquareToSnake(82, -20);
       board.movePlayer(1);
       board.movePlayer(4);
       board.movePlayer(6);
       board.movePlayer(2);
       board.movePlayer(6);
       assertTrue(player.wins(100));
	}
}
