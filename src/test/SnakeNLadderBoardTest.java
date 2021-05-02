package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import deserve.SnakeNLadderBoard;

public class SnakeNLadderBoardTest {

	private SnakeNLadderBoard board;
	
	@Before
	public void testMain() {
		board = new SnakeNLadderBoard();
	}
	
	@Test
	public void testNewMove() {
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        snakes.put(36,5);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(9,25);
        ladders.put(1,35);
        ladders.put(37,88);
        board.addSnakes(snakes);
        board.addLadders(ladders);
        board.nextMove(1);
        int i = board.nextMove(1);
        assertEquals(5, i);
	}

	@Test
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
	}
}
