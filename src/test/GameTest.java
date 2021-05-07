package test;

import static org.junit.Assert.assertEquals;
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

	/*@Test
	public void testSnakeNLadderCheck14_7() {
		Map<Integer, Integer> snakes = new HashMap<>();
		snakes.put(14,7);
		board.addSnakes(snakes);
		board.updatePlayerPosition(12);
		int i = board.nextMove(2);
		assertEquals(7, i);
	}
	
	@Test
	public void testSnakeNLadderCheck1() {
		Map<Integer, Integer> snakes = new HashMap<>();
		board.addSnakes(snakes);
		board.updatePlayerPosition(10);
		int i = board.nextMove(6);
		assertEquals(16, i);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNextMoveWithException() {
		Map<Integer, Integer> snakes = new HashMap<>();
		board.addSnakes(snakes);
		board.updatePlayerPosition(0);
		assertEquals(0, board.nextMove(-1));
	}

	@Test
	public void testRollDiceThrowsEvenNumber() {
		int value = board.rollEvenNumbersDice();
		assertEquals(0,value % 2);
	}

	@Test
	public void testIsWinnerPlayerScore100() {
		Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        snakes.put(36,5);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(9,25);
        ladders.put(2,35);
        ladders.put(37,88);
        ladders.put(90,100);
        board.updatePlayerPosition(0);
        board.addSnakes(snakes);
        board.addLadders(ladders);
        board.nextMove(2);
        board.nextMove(2);
        board.nextMove(2);
        int i = board.nextMove(2);
        assertEquals(100, i);
	}
	
	@Test
	public void testActualTurnCountMoreThan10() {
		Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        snakes.put(36,5);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(9,25);
        ladders.put(37,88);
        ladders.put(90,100);
        board.updatePlayerPosition(0);
        board.addSnakes(snakes);
        board.addLadders(ladders);
        board.nextMove(2);
        board.nextMove(4);
        board.nextMove(6);
        board.nextMove(2);
        board.nextMove(4);
        board.nextMove(6);
        board.nextMove(2);
        board.nextMove(2);
        board.nextMove(4);
        board.nextMove(2);
        board.nextMove(2);
        int i = board.nextMove(2);
        assertEquals(29, i);
	}
	
	@Test
	public void testPlayerScoreMoreThan100() {
		Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        snakes.put(36,5);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(9,25);
        ladders.put(2,35);
        ladders.put(37,88);
        ladders.put(90,98);
        board.updatePlayerPosition(0);
        board.addSnakes(snakes);
        board.addLadders(ladders);
        board.nextMove(2);
        board.nextMove(2);
        board.nextMove(2);
        int i = board.nextMove(4);
        assertEquals(98, i);
	}*/
}
