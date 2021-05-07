package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import deserve.Dice;

public class DiceTest {
	
	private Dice dice;
	
	@Before
	public void testMain() {
		dice = new Dice();;
	}
	
	@Test
	public void testRollNormalDiceWithRange1to6() {
	   int value = dice.roll();
       assertTrue(value <7);
       assertTrue(value >=1);
	}
	
	@Test
	public void testRollEvenNumbersDice() {
	   int value = dice.rollEvenNumbersDice();
       assertTrue(value %2 == 0);
	}
}
