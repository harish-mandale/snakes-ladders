package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import deserve.Game;
import deserve.Player;

public class GameTest {

	private Game board;
	
	@Before
	public void testMain() {
		board = new Game();
		board.setSquares(100);
	}
	
	@Test
	public void testPlayerAtFirstPosition() {
	   board.setSquares(100);
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToLadder(2, 4);
       board.setSquareToLadder(7, 2);
       board.setSquareToSnake(11, -6);
       assertTrue(board.notOver());
       assertTrue(board.getSquare(1).isOccupied());
       assertEquals(1, player.position());
	}
	
	@Test
	public void testFirstMoveWithNormalDice() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.movePlayer(1);
       assertTrue(board.notOver());
       assertTrue(board.getSquare(2).isOccupied());
       assertEquals(2, player.position());
	}
	
	@Test
	public void testSnakeAtPosition14MovePlayerTo7() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToSnake(14, -7);
       board.movePlayer(1);
       board.movePlayer(4);
       board.movePlayer(4);
       board.movePlayer(4);
       assertTrue(board.getSquare(7).isOccupied());
       assertTrue(board.notOver());
       assertEquals(7, player.position());
	}
	
	@Test
	public void testFirstMoveWithNormalDice4PositionUpWithLadder() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToLadder(2, 4);
       board.setSquareToLadder(7, 2);
       board.setSquareToSnake(11, -6);
       board.movePlayer(1);
       assertTrue(board.getSquare(6).isOccupied());
       assertTrue(board.notOver());
       assertEquals(6, player.position());
	}
	
	@Test
	public void testFirstMoveWithNormalDice8PositionDownWithSnake() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToLadder(7, 2);
       board.setSquareToSnake(11, -8);
       board.movePlayer(6);
       assertTrue(board.getSquare(9).isOccupied());
       assertTrue(board.notOver());
       board.movePlayer(2);
       assertEquals(3, player.position());
       assertTrue(board.notOver());
	}
	
	@Test
	public void testTotalTurn10Exausted() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToLadder(7, 20);
       board.setSquareToSnake(40, -26);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       board.movePlayer(2);
       assertTrue(board.getSquare(41).isOccupied());
       assertTrue(board.notOver());
       assertEquals(41, player.position());
	}
	
	@Test
	public void testPlayerWonTheGame() {
       Player player = new Player("Ramon");
       board.setPlayer(player);
       board.setSquareToLadder(6, 80);
       board.setSquareToLadder(66, 20);
       board.setSquareToSnake(82, -20);
       board.movePlayer(1);
       board.movePlayer(4);
       assertTrue(board.getSquare(86).isOccupied());
       assertEquals(86, player.position());
       board.movePlayer(6);
       board.movePlayer(2);
       assertTrue(board.getSquare(94).isOccupied());
       assertEquals(94, player.position());
       board.movePlayer(6);
       assertTrue(board.getSquare(100).isOccupied());
       assertFalse(board.notOver());
       assertEquals(100, player.position());
	}
}
